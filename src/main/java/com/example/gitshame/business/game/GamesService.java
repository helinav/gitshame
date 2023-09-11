package com.example.gitshame.business.game;

import com.example.gitshame.business.game.dto.GameResponse;
import com.example.gitshame.domain.game.Game;
import com.example.gitshame.domain.game.GameMapper;
import com.example.gitshame.domain.game.GameService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class GamesService {

    @Resource
    private GameService gameService;

    @Resource
    private GameMapper gameMapper;

    public GameResponse addGame(String gameName) {
        gameService.validateGameNameIsAvailable(gameName);
        Game game = createAndSaveGame(gameName);
        return gameMapper.toGameResponse(game);
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
}
