package com.example.gitshame.business.gameplay.dto;

import com.example.gitshame.domain.player.playergame.PlayerGame;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link PlayerGame}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaderboardResponse implements Serializable {

    private String username;
    @NotNull
    private Integer score;
}