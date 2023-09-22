package com.example.gitshame.business.gameplay.dto;

import com.example.gitshame.domain.player.playeranswer.PlayerAnswer;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link PlayerAnswer}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StartAnswerRequest implements Serializable {
    private Integer questionId;
    private Integer playerGameId;
}