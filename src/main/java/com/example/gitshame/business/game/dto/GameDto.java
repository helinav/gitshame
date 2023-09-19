package com.example.gitshame.business.game.dto;

import com.example.gitshame.domain.game.Game;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Game}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameDto implements Serializable {
    private Integer gameId;
    @NotNull
    @Size(max = 255)
    private String name;
}