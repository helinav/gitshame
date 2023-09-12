package com.example.gitshame.business.game.dto;

import com.example.gitshame.domain.game.Game;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Game}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class GameResponse implements Serializable {
    @NotNull
    private Integer gameId;
}