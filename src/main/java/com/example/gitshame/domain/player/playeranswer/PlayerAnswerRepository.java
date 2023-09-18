package com.example.gitshame.domain.player.playeranswer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlayerAnswerRepository extends JpaRepository<com.example.gitshame.domain.player.playeranswer.PlayerAnswer, Integer> {
    @Query("select p from PlayerAnswer p where p.playerGame.id = ?1 and p.isCorrect = null order by p.id limit 1")
    PlayerAnswer getNextPlayerAnswerBy(Integer playerGameId);

}