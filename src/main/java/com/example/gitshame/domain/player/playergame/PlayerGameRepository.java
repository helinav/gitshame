package com.example.gitshame.domain.player.playergame;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerGameRepository extends JpaRepository<PlayerGame, Integer> {
    @Query("select p from PlayerGame p where p.game.id = ?1 order by p.score DESC limit 5")
    List<PlayerGame> findPlayerGameByGame(Integer id);

}