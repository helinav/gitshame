package com.example.gitshame.domain.player.playergame;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PlayerGameService {

    @Resource
    PlayerGameRepository playerGameRepository;


    public void saveGameplay(PlayerGame playerGame) {
        playerGameRepository.save(playerGame);
    }
}
