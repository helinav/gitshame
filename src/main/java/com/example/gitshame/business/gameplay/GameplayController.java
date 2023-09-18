package com.example.gitshame.business.gameplay;


import com.example.gitshame.business.gameplay.dto.NewGameRequest;
import com.example.gitshame.business.gameplay.dto.StartAnswerRequest;
import com.example.gitshame.domain.question.QuestionInfo;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;


@RestController
public class GameplayController {
    @Resource
    private GameplayService gameplayService;

    @PostMapping("/gameplay")
    @Operation(summary = "Uue mängija mängu alustamine.")
    public void startNewGame(@RequestBody NewGameRequest request) {
        gameplayService.startNewGame(request);
    }

    @GetMapping("/next-question")
    @Operation(summary = "Järgmine küsimus.")
    public QuestionInfo getNextQuestion(@RequestParam Integer playerGameId) {
        return gameplayService.getNextQuestion(playerGameId);

    }

    @PostMapping("/game-answer")
    @Operation(summary = "Alusta vastamisega.")
    public void startPlayerAnswer(@RequestBody StartAnswerRequest startAnswerRequest) {
        gameplayService.startPlayerAnswer(startAnswerRequest);

    }

    @PatchMapping("/game-answer")
    public void submitPlayerAnswer(@RequestBody StartAnswerRequest startAnswerRequest) {
        gameplayService.startPlayerAnswer(startAnswerRequest);

    }
}




