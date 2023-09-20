package com.example.gitshame.business.gameplay;


import com.example.gitshame.business.gameplay.dto.*;
import com.example.gitshame.business.gameplay.dto.QuestionInfo;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class GameplayController {
    @Resource
    private GameplayService gameplayService;

    @PostMapping("/gameplay")
    @Operation(summary = "Uue mängija mängu alustamine.")
    public PlayerGameDto startNewGame(@RequestBody NewGameRequest request) {
        return gameplayService.startNewGame(request);
    }

    @GetMapping("/next-question")
    @Operation(summary = "Järgmine küsimus.")
    public QuestionInfo getNextQuestion(@RequestParam Integer playerGameId) {
        return gameplayService.getNextQuestion(playerGameId);
    }

    @PatchMapping("/game-answer")
    public void submitPlayerAnswer(@RequestBody StartAnswerRequest startAnswerRequest) {
        gameplayService.startPlayerAnswer(startAnswerRequest);

        //todo: sellest tuleb siis update
    }

    @GetMapping("/answers/select")
    @Operation(summary = "Toob ära select-küsimusetüüpide vastused.", description = "Tagastab JSONi vastavalt küsimusetüübile")
    public List<SelectResponse> getSelectAnswers(@RequestParam Integer questionId) {
        return gameplayService.getSelectAnswers(questionId);
    }

    @GetMapping("/answers/sequence")
    @Operation(summary = "Toob ära sequence küsimusetüübi vastused", description = "Tagastab JSONi vastavalt küsimusetüübile")
    public List<SequenceResponse> getSequenceAnswers(@RequestParam Integer questionId) {
        return gameplayService.getSequenceAnswers(questionId);
    }

    @GetMapping("/answers/textbox")
    @Operation(summary = "Toob ära textboxi küsimusetüübi vastused", description = "Tagastab JSONi vastavalt küsimusetüübile")
    public TextBoxResponse getTextBoxAnswer(@RequestParam Integer questionId) {
        return gameplayService.getTextBoxAnswer(questionId);
    }

    @GetMapping("/leaderboard")
    @Operation(summary = "Toob ära valitud mängu top5 parimat skoori")
    public List<LeaderboardResponse> getLeaderboardInfo(@RequestParam Integer gameId) {
        return gameplayService.getLeaderboardInfo(gameId);
    }
}



