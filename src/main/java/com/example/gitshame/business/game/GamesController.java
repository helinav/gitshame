package com.example.gitshame.business.game;
import com.example.gitshame.business.game.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GamesController {

    @Resource
    private GamesService gamesService;

    @PostMapping("/game")
    @Operation(summary = "Uue mängu lisamine. Tagastab gameId")
    public GameResponse addGame(@RequestParam String gameName) {
        return gamesService.addGame(gameName);
    }

    @PostMapping("/question")
    @Operation(summary = "Uue küsimuse lisamine. Tagastab questionId")
    public QuestionResponse addQuestion(@RequestParam Integer gameId, @RequestBody QuestionRequest request) {
        return gamesService.addQuestion(gameId, request);
    }

    @PostMapping("/answer")
    @Operation(summary = "Uue vastuse lisamine.")
    public void addAnswer(@RequestParam Integer questionId, @RequestBody AnswerRequest request) {
        gamesService.addAnswer(questionId, request);
    }

    @GetMapping("/game")
    @Operation(summary = "Toob ära kõik olemasolevad mängud.",
    description = "Tagastab gameId ja gameName.")
    public List<GameDto> getGames() {
        return gamesService.getGames();

    }
}
