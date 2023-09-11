package com.example.gitshame.domain.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GameRepository extends JpaRepository<Game, Integer> {
    @Query("select (count(g) > 0) from Game g where g.name = ?1")
    boolean gameExistsBy(String name);

}