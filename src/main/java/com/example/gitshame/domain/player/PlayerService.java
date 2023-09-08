package com.example.gitshame.domain.player;

import com.example.gitshame.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Resource
    private PlayerRepository playerRepository;
    public void savePlayer(Player player) {
        playerRepository.save(player);
    }

    public void validateEmailIsAvailabe(String email) {
        boolean emailExists = playerRepository.existsByEmail(email);
        ValidationService.validateEmailIsAvailable(emailExists);
    }
}
