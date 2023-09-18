package com.example.gitshame.domain.player.playeranswer;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerAnswerService {

    @Resource
    private PlayerAnswerRepository playerAnswerRepository;
    public void savePlayerAnswers(List<com.example.gitshame.domain.player.playeranswer.PlayerAnswer> playerAnswers) {
        playerAnswerRepository.saveAll(playerAnswers);
    }

    public PlayerAnswer getNextPlayerAnswerBy(Integer playerGameId) {
        return playerAnswerRepository.getNextPlayerAnswerBy(playerGameId);

    }

    public void savePlayerAnswer(PlayerAnswer playerAnswer) {
        playerAnswerRepository.save(playerAnswer);
    }
}
