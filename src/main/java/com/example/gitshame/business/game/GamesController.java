package com.example.gitshame.business.game;


import com.example.gitshame.business.game.dto.GameResponse;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GamesController {

    @Resource
    private GamesService gamesService;


    @PostMapping("/game")
    public GameResponse addGame(@RequestParam String gameName) {
        return gamesService.addGame(gameName);
    }
}
