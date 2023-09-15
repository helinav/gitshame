package com.example.gitshame.domain.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    @Query("select (count(p) > 0) from Player p where p.email = ?1")
    boolean existsByEmail(String email);

    @Query("select p from Player p where p.user.id = ?1")
    Player getPlayerBy(Integer id);




}