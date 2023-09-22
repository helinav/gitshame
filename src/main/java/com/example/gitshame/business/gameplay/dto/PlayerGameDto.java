package com.example.gitshame.business.gameplay.dto;

import com.example.gitshame.domain.player.playergame.PlayerGame;
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
public class PlayerGameDto implements Serializable {
    private Integer playerGameId;
}