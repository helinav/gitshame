package com.example.gitshame.domain.game;

import com.example.gitshame.domain.user.UserRepository;
import com.example.gitshame.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Resource
    private GameRepository gameRepository;
    private final UserRepository userRepository;

    public GameService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveGame(Game game) {
        gameRepository.save(game);
    }

    public void validateGameNameIsAvailable(String gameName) {
        boolean gameExists = gameRepository.gameExistsBy(gameName);
        ValidationService.validateGameNameIsAvailable(gameExists);
    }
}
