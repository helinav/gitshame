package com.example.gitshame.business.gameplay;


import com.example.gitshame.business.gameplay.dto.PlayerAnswerRequest;
import com.example.gitshame.business.gameplay.dto.PlayerGameRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GameplayController {
    @Resource
    private GameplayService gameplayService;

    @PostMapping("/gameplay")
    @Operation(summary = "Uue mängija mängu alustamine.")
    public void addGameplay (@RequestBody PlayerGameRequest request) {
        gameplayService.addGameplay(request);
    }

    @PostMapping("/game-answer")
    public void addPlayerAnswer(@RequestBody PlayerAnswerRequest playerAnswerRequest) {
        gameplayService.addPlayerAnswer(playerAnswerRequest);

    }
}




