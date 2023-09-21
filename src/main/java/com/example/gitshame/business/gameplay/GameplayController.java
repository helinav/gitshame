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

    @GetMapping("/possible-answers/multiple-choice")
    @Operation(summary = "Toob ära mitmik küsimusetüübi võimalikud vastused.", description = "Tagastab JSONi vastavalt küsimusetüübile")
    public List<MultipleChoiceAnswerInfo> getSelectAnswers(@RequestParam Integer questionId) {
        return gameplayService.getSelectAnswers(questionId);
    }

    @GetMapping("/possible-answers/sequence")
    @Operation(summary = "Toob ära sequence küsimusetüübi vastused", description = "Tagastab JSONi vastavalt küsimusetüübile")
    public List<SequenceTypeAnswerInfo> getSequenceAnswers(@RequestParam Integer questionId) {
        return gameplayService.getSequenceAnswers(questionId);
    }

    @GetMapping("/possible-answer/textbox")
    @Operation(summary = "Toob ära textboxi küsimusetüübi vastused", description = "Tagastab JSONi vastavalt küsimusetüübile")
    public TextBoxAnswerInfo getTextBoxAnswer(@RequestParam Integer questionId) {
        return gameplayService.getTextBoxAnswer(questionId);
    }

    @GetMapping("/leaderboard")
    @Operation(summary = "Toob ära valitud mängu top5 parimat skoori")
    public List<LeaderboardResponse> getLeaderboardInfo(@RequestParam Integer gameId) {
        return gameplayService.getLeaderboardInfo(gameId);
    }

    @PatchMapping("/answer/multiple-choice")
    @Operation(summary = "Uuendab peale mitmiktüüpi küsimuse vastamist andmebaasi andmeid")
    public Boolean submitMultipleChoicePlayerAnswer(@RequestParam Integer playerGameId, @RequestBody List<MultipleChoiceAnswerInfo> answers) {
       return gameplayService.submitMultipleChoicePlayerAnswer(playerGameId, answers);
    }

    @PatchMapping("/answer/sequence")
    @Operation(summary = "Uuendab peale sequencetüüpi küsimuse vastamist andmebaasi andmeid")
    public Boolean submitSequenceTypePlayerAnswer(@RequestParam Integer playerGameId, @RequestBody List<SequenceTypeAnswerInfo> answers) {
        return gameplayService.submitSequenceTypePlayerAnswer(playerGameId, answers);
    }

    @PatchMapping("/answer-textbox")
    @Operation(summary = "Uuendab peale textboxtüüpi küsimuse vastamist andmebaasi andmeid")
    public Boolean submitTextBoxPlayerAnswer (@RequestParam Integer playerGameId, @RequestBody TextBoxAnswerInfo answer) {
        return gameplayService.submitTextBoxPlayerAnswer(playerGameId, answer);
    }
}



