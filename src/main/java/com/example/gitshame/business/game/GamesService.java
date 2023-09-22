package com.example.gitshame.business.game;

import com.example.gitshame.business.game.dto.*;
import com.example.gitshame.domain.answer.Answer;
import com.example.gitshame.domain.answer.AnswerMapper;
import com.example.gitshame.domain.answer.AnswerService;
import com.example.gitshame.domain.game.Game;
import com.example.gitshame.domain.game.GameMapper;
import com.example.gitshame.domain.game.GameService;
import com.example.gitshame.domain.image.Image;
import com.example.gitshame.domain.image.ImageMapper;
import com.example.gitshame.domain.image.ImageService;
import com.example.gitshame.domain.question.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamesService {
    @Resource
    private GameService gameService;

    @Resource
    private GameMapper gameMapper;

    @Resource
    private ImageMapper imageMapper;

    @Resource
    private QuestionMapper questionMapper;

    @Resource
    private ImageService imageService;

    @Resource
    private TypeService typeService;

    @Resource
    private QuestionService questionService;

    @Resource
    private AnswerMapper answerMapper;

    @Resource
    private AnswerService answerService;

    public GameResponse addGame(String gameName) {
        gameService.validateGameNameIsAvailable(gameName);
        Game game = createAndSaveGame(gameName);
        return gameMapper.toGameResponse(game);
    }

    public QuestionResponse addQuestion(Integer gameId, QuestionRequest request) {
        Question question = createQuestion(request);
        handleImage(request, question);
        setGameToQuestion(gameId, question);
        setTypeToQuestion(request.getTypeId(), question);
        saveQuestion(question);
        return questionMapper.toQuestionResponse(question);
    }

    public void addAnswer(Integer questionId, AnswerRequest request) {
        Answer answer = answerMapper.toAnswer(request);
        setQuestionToAnswer(questionId, answer);
        answerService.saveAnswer(answer);
    }

    private Game createAndSaveGame(String gameName) {
        Game game = createGame(gameName);
        gameService.saveGame(game);
        return game;
    }

    private static Game createGame(String gameName) {
        Game game = new Game();
        game.setName(gameName);
        return game;
    }

    private Question createQuestion(QuestionRequest request) {
        return questionMapper.toQuestion(request);
    }

    private void handleImage(QuestionRequest request, Question question) {
        if (hasImage(request)) {
            Image image = createAndSaveQuestionImage(request);
            question.setImage(image);
        }
    }

    private static boolean hasImage(QuestionRequest request) {
        return !request.getImageData().isEmpty();
    }

    private Image createAndSaveQuestionImage(QuestionRequest request) {
        Image image = imageMapper.toImage(request);
        imageService.saveImage(image);
        return image;
    }

    private void setGameToQuestion(Integer gameId, Question question) {
        Game game = gameService.getGame(gameId);
        question.setGame(game);
    }

    private void setTypeToQuestion(Integer typeId, Question question) {
        Type type = typeService.getType(typeId);
        question.setType(type);
    }

    private void saveQuestion(Question question) {
        questionService.saveQuestion(question);
    }

    private void setQuestionToAnswer(Integer questionId, Answer answer) {
        Question question = questionService.getQuestion(questionId);
        answer.setQuestion(question);
    }

    public List<GameDto> getGames() {
        List<Game> games = gameService.getGames();
        return gameMapper.toGameDtos(games);

    }
}
