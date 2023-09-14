package com.example.gitshame.business.game.dto;

import com.example.gitshame.domain.answer.Answer;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Answer}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerRequest implements Serializable {
    @NotNull
    @Size(max = 255)
    private String text;
    @NotNull
    private Boolean isCorrect = false;
    private Integer sequence;
}