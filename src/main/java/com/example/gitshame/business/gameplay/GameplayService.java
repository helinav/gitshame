package com.example.gitshame.business.gameplay;

import com.example.gitshame.business.Status;
import com.example.gitshame.business.gameplay.dto.*;
import com.example.gitshame.domain.answer.Answer;
import com.example.gitshame.domain.answer.AnswerMapper;
import com.example.gitshame.domain.answer.AnswerService;
import com.example.gitshame.domain.game.Game;
import com.example.gitshame.domain.game.GameService;
import com.example.gitshame.domain.player.Player;
import com.example.gitshame.domain.player.PlayerService;
import com.example.gitshame.domain.player.playeranswer.PlayerAnswer;
import com.example.gitshame.domain.player.playeranswer.PlayerAnswerService;
import com.example.gitshame.domain.player.playergame.PlayerGame;
import com.example.gitshame.domain.player.playergame.PlayerGameMapper;
import com.example.gitshame.domain.player.playergame.PlayerGameService;
import com.example.gitshame.domain.question.*;
import com.example.gitshame.util.TimeConverter;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import static com.example.gitshame.business.Status.NEXT_QUESTION;
import static com.example.gitshame.business.Status.PENDING_QUESTION;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
public class GameplayService {

    @Resource
    private GameService gameService;
    @Resource
    private PlayerGameMapper playerGameMapper;
    @Resource
    private PlayerGameService playerGameService;
    @Resource
    private PlayerService playerService;
    @Resource
    private QuestionService questionService;
    @Resource
    private PlayerAnswerService playerAnswerService;
    @Resource
    private QuestionMapper questionMapper;
    @Resource
    private AnswerService answerService;
    @Resource
    private AnswerMapper answerMapper;

    public PlayerGameDto startNewGame(NewGameRequest request) {
        Integer gameId = request.getGameId();
        PlayerGame playerGame = playerGameMapper.toPlayerGame((request));
        getAndSetGame(gameId, playerGame);
        getAndSetPlayer(request.getPlayerId(), playerGame);
        playerGameService.savePlayerGame(playerGame);
        List<Question> questions = questionService.findAllActiveQuestionsBy(gameId);
        List<PlayerAnswer> playerAnswers = new ArrayList<>();
        for (Question question : questions) {
            PlayerAnswer playerAnswer = new PlayerAnswer();
            playerAnswer.setPlayerGame(playerGame);
            playerAnswer.setQuestion(question);
            playerAnswers.add(playerAnswer);
            playerAnswer.setStatus(NEXT_QUESTION.getLetter());
        }
        playerAnswerService.savePlayerAnswers(playerAnswers);
        return playerGameMapper.toPlayerGameDto(playerGame);
    }

    public QuestionInfo getNextQuestion(Integer playerGameId) {
        long totalNumberOfQuestions = playerAnswerService.getTotalNumberOfQuestions(playerGameId);
        long numberOfQuestionsCompleted = playerAnswerService.getNumberOfQuestionsCompleted(playerGameId);
        Boolean isGameOver = totalNumberOfQuestions == numberOfQuestionsCompleted;
        if (isGameOver) {
            return new QuestionInfo(isGameOver);
        }

        PlayerAnswer nextPlayerAnswer = playerAnswerService.getNextValidPlayerAnswerBy(playerGameId);
        if (NEXT_QUESTION.getLetter().equals(nextPlayerAnswer.getStatus())) {
            nextPlayerAnswer.setStartTime(TimeConverter.getEstonianTimeZoneInstant());
            nextPlayerAnswer.setStatus(PENDING_QUESTION.getLetter());
            playerAnswerService.savePlayerAnswer(nextPlayerAnswer);
        }

        long nextQuestionNumber = playerAnswerService.getNextQuestionNumber(playerGameId);

        QuestionInfo questionInfo = questionMapper.toQuestionInfo(nextPlayerAnswer.getQuestion());
        questionInfo.setStrikeCount(nextPlayerAnswer.getPlayerGame().getStrikeCount());
        questionInfo.setTotalNumberOfQuestions(totalNumberOfQuestions);
        questionInfo.setQuestionNumber(nextQuestionNumber);
        questionInfo.setIsGameOver(isGameOver);


        return questionInfo;
    }

    public List<MultipleChoiceAnswerInfo> getSelectAnswers(Integer questionId) {
        List<Answer> answers = answerService.getAnswers(questionId);
        return answerMapper.toSelectResponse(answers);
    }

    public List<SequenceTypeAnswerInfo> getSequenceAnswers(Integer questionId) {
        List<Answer> answers = answerService.getAnswers(questionId);
        return answerMapper.toSequenceResponses(answers);
    }

    public TextBoxAnswerInfo getTextBoxAnswer(Integer questionId) {
        Answer answer = answerService.getAnswer(questionId);
        return answerMapper.toTextBoxResponse(answer);
    }

    public List<LeaderboardResponse> getLeaderboardInfo(Integer gameId) {
        List<PlayerGame> leaderboardInfos = playerGameService.getLeaderboardInfo(gameId);
        return playerGameMapper.toLeaderBoardResponses(leaderboardInfos);
    }

    @Transactional
    public Boolean submitMultipleChoicePlayerAnswer(Integer playerGameId, List<MultipleChoiceAnswerInfo> multipleChoiceAnswerInfos) {
        Instant timestamp = TimeConverter.getEstonianTimeZoneInstant();
        PlayerGame playerGame = playerGameService.getPlayerGame(playerGameId);
        Integer playerCurrentScore = playerGame.getScore();
        PlayerAnswer playerAnswer = playerAnswerService.getPlayerPendingAnswerBy(playerGameId);
        playerAnswer.setEndTime(timestamp);

        boolean allAnswersAreCorrect = allMultipleChoiceAnswersAreCorrect(multipleChoiceAnswerInfos);

        if (allAnswersAreCorrect) {
            playerAnswer.setIsCorrect(true);
            int playerNewScore = calculatePlayerNewScore(playerAnswer, playerCurrentScore);
            playerGame.setScore(playerNewScore);

        } else {
            playerAnswer.setIsCorrect(false);
            playerGame.setStrikeCount(playerGame.getStrikeCount() + 1);
        }

        playerAnswer.setStatus(Status.COMPLETED_QUESTION.getLetter());
        playerAnswerService.savePlayerAnswer(playerAnswer);
        playerGameService.savePlayerGame(playerGame);
        return playerAnswer.getIsCorrect();
    }

    @Transactional
    public Boolean submitTextBoxPlayerAnswer(Integer playerGameId, TextBoxAnswerInfo textBoxAnswerInfo) {
        Instant timestamp = TimeConverter.getEstonianTimeZoneInstant();
        PlayerGame playerGame = playerGameService.getPlayerGame(playerGameId);
        Integer playerCurrentScore = playerGame.getScore();
        PlayerAnswer playerAnswer = playerAnswerService.getPlayerPendingAnswerBy(playerGameId);
        playerAnswer.setEndTime(timestamp);
        Answer answer = answerService.getAnswerBy(textBoxAnswerInfo.getAnswerId());

        if (textBoxAnswerInfo.getText().equals(answer.getText())) {
            playerAnswer.setIsCorrect(true);
            int playerNewScore = calculatePlayerNewScore(playerAnswer, playerCurrentScore);
            playerGame.setScore(playerNewScore);

        } else {
            playerAnswer.setIsCorrect(false);
            playerGame.setStrikeCount(playerGame.getStrikeCount() + 1);
        }
        playerAnswer.setStatus(Status.COMPLETED_QUESTION.getLetter());
        playerAnswerService.savePlayerAnswer(playerAnswer);
        playerGameService.savePlayerGame(playerGame);
        return playerAnswer.getIsCorrect();
    }

    @Transactional
    public Boolean submitSequenceTypePlayerAnswer(Integer playerGameId, List<SequenceTypeAnswerInfo> sequenceTypeAnswerInfos) {
        Instant timestamp = TimeConverter.getEstonianTimeZoneInstant();
        PlayerGame playerGame = playerGameService.getPlayerGame(playerGameId);
        Integer playerCurrentScore = playerGame.getScore();

        PlayerAnswer playerAnswer = playerAnswerService.getPlayerPendingAnswerBy(playerGameId);
        playerAnswer.setEndTime(timestamp);

        boolean allAnswersAreCorrect = allSequenceTypeAnswersAreCorrect(sequenceTypeAnswerInfos);

        if (allAnswersAreCorrect) {
            playerAnswer.setIsCorrect(true);
            int playerNewScore = calculatePlayerNewScore(playerAnswer, playerCurrentScore);
            playerGame.setScore(playerNewScore);

        } else {
            playerAnswer.setIsCorrect(false);
            playerGame.setStrikeCount(playerGame.getStrikeCount() + 1);
        }

        playerAnswer.setStatus(Status.COMPLETED_QUESTION.getLetter());
        playerAnswerService.savePlayerAnswer(playerAnswer);
        playerGameService.savePlayerGame(playerGame);
        return playerAnswer.getIsCorrect();
    }

    private void getAndSetGame(Integer gameId, PlayerGame playerGame) {
        Game game = gameService.getGame(gameId);
        playerGame.setGame(game);
    }

    private void getAndSetPlayer(Integer playerId, PlayerGame playerGame) {
        Player player = playerService.getPlayerById(playerId);
        playerGame.setPlayer(player);
    }

    private static int calculatePlayerNewScore(PlayerAnswer playerAnswer, Integer playerCurrentScore) {
        return playerCurrentScore + (int) (playerAnswer.getQuestion().getTimeLimit() - Duration.between(playerAnswer.getStartTime(), playerAnswer.getEndTime()).getSeconds());
    }

    private boolean allMultipleChoiceAnswersAreCorrect(List<MultipleChoiceAnswerInfo> multipleChoiceAnswerInfos) {
        for (MultipleChoiceAnswerInfo multipleChoiceAnswerInfo : multipleChoiceAnswerInfos) {
            Answer answer = answerService.getAnswerBy(multipleChoiceAnswerInfo.getAnswerId());
            if (isIncorrectMultipleChoiceAnswer(multipleChoiceAnswerInfo, answer)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isIncorrectMultipleChoiceAnswer(MultipleChoiceAnswerInfo multipleChoiceAnswerInfo, Answer answer) {
        return !answer.getIsCorrect().equals(multipleChoiceAnswerInfo.getIsSelected());
    }

    private boolean allSequenceTypeAnswersAreCorrect(List<SequenceTypeAnswerInfo> sequenceTypeAnswerInfos) {
        for (SequenceTypeAnswerInfo sequenceTypeAnswerInfo : sequenceTypeAnswerInfos) {
            Answer answer = answerService.getAnswerBy(sequenceTypeAnswerInfo.getAnswerId());
            if (isIncorrectSequenceTypeAnswer(sequenceTypeAnswerInfo, answer)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isIncorrectSequenceTypeAnswer(SequenceTypeAnswerInfo sequenceTypeAnswerInfo, Answer answer) {
        return !(answer.getIsCorrect().equals(sequenceTypeAnswerInfo.getIsSelected() && answer.getSequence().equals(sequenceTypeAnswerInfo.getSequence())));
    }
}
