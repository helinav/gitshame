package com.example.gitshame.domain.game;

import com.example.gitshame.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Resource
    private GameRepository gameRepository;


    public void saveGame(Game game) {
        gameRepository.save(game);
    }

    public void validateGameNameIsAvailable(String gameName) {
        boolean gameExists = gameRepository.gameExistsBy(gameName);
        ValidationService.validateGameNameIsAvailable(gameExists);
    }

    public Game getGame(Integer gameId) {
        return gameRepository.getReferenceById(gameId);
    }
}
