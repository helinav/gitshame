package com.example.gitshame.business.game;


import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameResourceController {

    @Resource
    private GameResourceService gameResourceService;


    @PostMapping("/game")
    public void addGame(@RequestParam String gameName ) {
        gameResourceService.addGame(gameName);
    }
}
