package com.example.gitshame.business.game;
import com.example.gitshame.business.game.dto.AnswerRequest;
import com.example.gitshame.business.game.dto.GameResponse;
import com.example.gitshame.business.game.dto.QuestionRequest;
import com.example.gitshame.business.game.dto.QuestionResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
