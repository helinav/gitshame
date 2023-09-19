package com.example.gitshame.domain.player.playeranswer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PlayerAnswerRepository extends JpaRepository<com.example.gitshame.domain.player.playeranswer.PlayerAnswer, Integer> {
    @Query("select p from PlayerAnswer p where p.playerGame.id = ?1 and p.status = ?2")
    Optional<PlayerAnswer> findPlayerAnswerBy(Integer playerGameId, String status);



    @Query("select p from PlayerAnswer p where p.playerGame.id = ?1 and p.status = ?2 order by p.id limit 1")
    PlayerAnswer getFirstPlayerAnswerBy(Integer playerGameId, String status);

}