package com.example.gitshame.domain.question;

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
public class QuestionInfo implements Serializable {
    private Integer questionId;
    private String questionText;
    private String answerExplanation;
    private String typeName;
    private String imageData;
    private Integer strikeCount;
    private Long questionNumber;
    private Long totalNumberOfQuestions;
    private Boolean isGameOver;


    public QuestionInfo(Boolean isGameOver) {
        this.isGameOver = isGameOver;
    }
}