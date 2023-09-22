package com.example.gitshame.domain.player.playergame;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerGameService {

    @Resource
    PlayerGameRepository playerGameRepository;

    public void savePlayerGame(PlayerGame playerGame) {
        playerGameRepository.save(playerGame);
    }

    public List<PlayerGame> getLeaderboardInfo(Integer gameId) {
        return playerGameRepository.findPlayerGameByGame(gameId);

    }

    public PlayerGame getPlayerGame(Integer playerGameId) {
        return playerGameRepository.getReferenceById(playerGameId);
    }
}
