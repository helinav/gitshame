package com.example.gitshame.business.gameplay;

import com.example.gitshame.business.gameplay.dto.NewGameRequest;
import com.example.gitshame.business.gameplay.dto.PlayerGameDto;
import com.example.gitshame.business.gameplay.dto.StartAnswerRequest;
import com.example.gitshame.domain.answer.AnswerService;
import com.example.gitshame.domain.game.Game;
import com.example.gitshame.domain.game.GameService;
import com.example.gitshame.domain.player.Player;
import com.example.gitshame.domain.player.PlayerService;
import com.example.gitshame.domain.player.playeranswer.PlayerAnswer;
import com.example.gitshame.domain.player.playeranswer.PlayerAnswerMapper;
import com.example.gitshame.domain.player.playeranswer.PlayerAnswerService;
import com.example.gitshame.domain.player.playergame.PlayerGame;
import com.example.gitshame.domain.player.playergame.PlayerGameMapper;
import com.example.gitshame.domain.player.playergame.PlayerGameService;
import com.example.gitshame.domain.question.Question;
import com.example.gitshame.domain.question.QuestionInfo;
import com.example.gitshame.domain.question.QuestionMapper;
import com.example.gitshame.domain.question.QuestionService;
import com.example.gitshame.util.TimeConverter;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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
    private PlayerAnswerMapper playerAnswerMapper;
    @Resource
    private AnswerService answerService;
    @Resource
    private QuestionService questionService;
    @Resource
    private PlayerAnswerService playerAnswerService;
    @Resource
    private QuestionMapper questionMapper;

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
        }
        playerAnswerService.savePlayerAnswers(playerAnswers);
        return playerGameMapper.toPlayerGameDto(playerGame);
    }

    public QuestionInfo getNextQuestion(Integer playerGameId) {
        PlayerAnswer nextPlayerAnswer = playerAnswerService.getNextPlayerAnswerBy(playerGameId);
        nextPlayerAnswer.setStartTime(TimeConverter.getEstonianTimeZoneInstant());
        playerAnswerService.savePlayerAnswer(nextPlayerAnswer);
        return questionMapper.toQuestionInfo(nextPlayerAnswer.getQuestion());
    }

    public void startPlayerAnswer(StartAnswerRequest startAnswerRequest) {
        PlayerAnswer playerAnswer = playerAnswerMapper.toPlayerAnswer(startAnswerRequest);
        getAndSetQuestion(startAnswerRequest, playerAnswer);
    }

    private void getAndSetGame(Integer gameId, PlayerGame playerGame) {
        Game game = gameService.getGame(gameId);
        playerGame.setGame(game);
    }

    private void getAndSetPlayer(Integer playerId, PlayerGame playerGame) {
        Player player = playerService.getPlayerById(playerId);
        playerGame.setPlayer(player);
    }


    private void getAndSetQuestion(StartAnswerRequest startAnswerRequest, PlayerAnswer playerAnswer) {
        Question question = questionService.getQuestion(startAnswerRequest.getQuestionId());
        playerAnswer.setQuestion(question);
    }


}
