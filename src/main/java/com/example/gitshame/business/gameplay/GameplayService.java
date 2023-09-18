package com.example.gitshame.business.gameplay;

import com.example.gitshame.business.gameplay.dto.PlayerAnswerRequest;
import com.example.gitshame.business.gameplay.dto.PlayerGameRequest;
import com.example.gitshame.domain.answer.Answer;
import com.example.gitshame.domain.answer.AnswerService;
import com.example.gitshame.domain.game.Game;
import com.example.gitshame.domain.game.GameService;
import com.example.gitshame.domain.player.Player;
import com.example.gitshame.domain.player.PlayerService;
import com.example.gitshame.domain.player.playeranswer.PlayerAnswer;
import com.example.gitshame.domain.player.playeranswer.PlayerAnswerMapper;
import com.example.gitshame.domain.player.playergame.PlayerGame;
import com.example.gitshame.domain.player.playergame.PlayerGameMapper;
import com.example.gitshame.domain.player.playergame.PlayerGameService;
import com.example.gitshame.domain.question.Question;
import com.example.gitshame.domain.question.QuestionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class GameplayService {
    @Resource
    GameService gameService;
    @Resource
    PlayerGameMapper playerGameMapper;
    @Resource
    PlayerGameService playerGameService;
    @Resource
    PlayerService playerService;
    @Resource
    PlayerAnswerMapper playerAnswerMapper;
    @Resource
    AnswerService answerService;
    @Resource
    QuestionService questionService;

    public void addGameplay(PlayerGameRequest request) {
        PlayerGame playerGame = playerGameMapper.toPlayerGame((request));
        getAndSetGame(request, playerGame);
        getAndSetPlayer(request, playerGame);
        playerGameService.saveGameplay(playerGame);
    }

    public void addPlayerAnswer(PlayerAnswerRequest playerAnswerRequest) {
        PlayerAnswer playerAnswer = playerAnswerMapper.toPlayerAnswer(playerAnswerRequest);
        getAndSetAnswer(playerAnswerRequest, playerAnswer);
        getAndSetQuestion(playerAnswerRequest, playerAnswer);
        

    }

    private void getAndSetGame(PlayerGameRequest request, PlayerGame playerGame) {
        Game game = gameService.getGame(request.getGameId());
        playerGame.setGame(game);
    }

    private void getAndSetPlayer(PlayerGameRequest request, PlayerGame playerGame) {
        Player player = playerService.getPlayerById(request.getPlayerId());
        playerGame.setPlayer(player);
    }

    private void getAndSetAnswer(PlayerAnswerRequest playerAnswerRequest, PlayerAnswer playerAnswer) {
        Answer answer = answerService.getAnswer(playerAnswerRequest.getAnswerId());
        playerAnswer.setAnswer(answer);
    }

    private void getAndSetQuestion(PlayerAnswerRequest playerAnswerRequest, PlayerAnswer playerAnswer) {
        Question question = questionService.getQuestion(playerAnswerRequest.getQuestionId());
        playerAnswer.setQuestion(question);
    }
}
