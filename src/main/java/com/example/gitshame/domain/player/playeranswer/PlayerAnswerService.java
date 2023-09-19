package com.example.gitshame.domain.player.playeranswer;

import com.example.gitshame.business.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerAnswerService {

    @Resource
    private PlayerAnswerRepository playerAnswerRepository;
    public void savePlayerAnswers(List<com.example.gitshame.domain.player.playeranswer.PlayerAnswer> playerAnswers) {
        playerAnswerRepository.saveAll(playerAnswers);
    }

    public PlayerAnswer getNextValidPlayerAnswerBy(Integer playerGameId) {
        Optional<PlayerAnswer> optionalPlayerAnswer = playerAnswerRepository.findPlayerAnswerBy(playerGameId, Status.PENDING_QUESTION.getLetter());
        if (optionalPlayerAnswer.isPresent()) {
            return optionalPlayerAnswer.get();
        }

        return playerAnswerRepository.getFirstPlayerAnswerBy(playerGameId, Status.NEXT_QUESTION.getLetter());

    }

    public void savePlayerAnswer(PlayerAnswer playerAnswer) {
        playerAnswerRepository.save(playerAnswer);
    }
}
