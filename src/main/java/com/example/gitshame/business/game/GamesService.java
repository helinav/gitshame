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
import com.example.gitshame.util.ImageConverter;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

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
        Question question = createQuestion(gameId, request);
        Image image = createAndSaveQuestionImage(request);
        setGameIdToQuestion(gameId, question);
        setTypeIdToQuestion(request, question);
        setImageIdToQuestion(question, image);
        saveQuestion(question);
        return questionMapper.toQuestionResponse(question);
    }

    public void addAnswer(Integer questionId, AnswerRequest request) {
        Answer answer = createAnswer(request);
        setQuestionIdToAnswer(questionId, answer);
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

    private Question createQuestion(Integer gameId, QuestionRequest request) {
        return questionMapper.toQuestion(request, gameId);
    }

    private Image createAndSaveQuestionImage(QuestionRequest request) {
        Image image = imageMapper.toImage(request);
        String requestImageData = request.getImageData();
        Image imageFromData = ImageConverter.imageDataToImage(requestImageData);
        image.setData(imageFromData.getData());
        imageService.saveImage(image);
        return image;
    }

    private void setGameIdToQuestion(Integer gameId, Question question) {
        Game game = gameService.getGame(gameId);
        question.setGame(game);
    }

    private void setTypeIdToQuestion(QuestionRequest request, Question question) {
        Type type = typeService.getType(request.getTypeId());
        question.setType(type);
    }

    private static void setImageIdToQuestion(Question question, Image image) {
        question.setImage(image);
    }

    private Question saveQuestion(Question question) {
        questionService.saveQuestion(question);
        return question;
    }

    private Answer createAnswer(AnswerRequest request) {
        return answerMapper.toAnswer(request);
    }

    private void setQuestionIdToAnswer(Integer questionId, Answer answer) {
        Question question = questionService.getQuestion(questionId);
        answer.setQuestion(question);
    }

}
