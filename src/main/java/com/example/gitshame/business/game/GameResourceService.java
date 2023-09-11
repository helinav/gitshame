package com.example.gitshame.business.game;

import com.example.gitshame.domain.game.GameService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class GameResourceService {

    @Resource
    private GameService gameService;



    public void addGame(String gameName) {
        gameService.validateGameNameIsAvailable(gameName);
        gameService.saveGame(gameName);
    }
}
