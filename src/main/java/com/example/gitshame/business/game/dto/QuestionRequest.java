package com.example.gitshame.business.game.dto;

import com.example.gitshame.domain.question.Question;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * DTO for {@link Question}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest implements Serializable {

    @NotNull
    @Size(max = 255)
    private String text;
    @NotNull
    @Size(max = 255)
    private String answerExplanation;
    @NotNull
    private Integer timeLimit;
    private Integer typeId;
    private String imageData;
}