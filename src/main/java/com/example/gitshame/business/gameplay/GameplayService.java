package com.example.gitshame.business.gameplay;

import com.example.gitshame.business.gameplay.dto.*;
import com.example.gitshame.domain.answer.Answer;
import com.example.gitshame.domain.answer.AnswerMapper;
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
import com.example.gitshame.domain.question.*;
import com.example.gitshame.infrastructure.exception.DataNotFoundException;
import com.example.gitshame.util.TimeConverter;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.example.gitshame.business.Status.NEXT_QUESTION;
import static com.example.gitshame.business.Status.PENDING_QUESTION;
import static com.example.gitshame.validation.Error.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    private QuestionService questionService;
    @Resource
    private PlayerAnswerService playerAnswerService;
    @Resource
    private QuestionMapper questionMapper;
    @Resource
    private QuestionRepository questionRepository;
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
       PlayerAnswer nextPlayerAnswer = playerAnswerService.getNextValidPlayerAnswerBy(playerGameId);
        if (NEXT_QUESTION.getLetter().equals(nextPlayerAnswer.getStatus())) {
            nextPlayerAnswer.setStartTime(TimeConverter.getEstonianTimeZoneInstant());
            nextPlayerAnswer.setStatus(PENDING_QUESTION.getLetter());
            playerAnswerService.savePlayerAnswer(nextPlayerAnswer);
        }
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


    public ResponseEntity<?> getAnswers(Integer questionId) {

        Optional<Question> optionalQuestion = questionRepository.findById(questionId);

        if (optionalQuestion.isEmpty()) {
            throw new DataNotFoundException(INVALID_QUESTION_ID.getMessage(), INVALID_QUESTION_ID.getErrorCode());
        }
        String questionType = optionalQuestion.get().getType().getName();

        switch (questionType) {
            case "radio": {
                List<Answer> answers = answerService.getAnswers(questionId);
                List<SelectResponse> selectRespons = answerMapper.toRadioResponses(answers);
                return ResponseEntity.ok(selectRespons);
            }
            case "checkbox": {
                List<Answer> answers = answerService.getAnswers(questionId);
                List<CheckboxResponse> checkboxResponses = answerMapper.toCheckboxResponses(answers);
                return ResponseEntity.ok(checkboxResponses);
            }
            case "textbox": {
                Answer answer = answerService.getAnswer(questionId);
                TextBoxResponse textboxResponse = answerMapper.toTextBoxResponse(answer);
                return ResponseEntity.ok(textboxResponse);
            }
            case "sequence": {
                List<Answer> answers = answerService.getAnswers(questionId);
                List<SequenceResponse> sequenceResponses = answerMapper.toSequenceResponses(answers);
                return ResponseEntity.ok(sequenceResponses);
            }
        };
        return null;
    }

}
