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
    @NotNull
    @Size(max = 255)
    private String questionText;
    @NotNull
    @Size(max = 255)
    private String answerExplanation;
    private String typeName;
    private String imageData;

    private Integer strikeCount;
    private Integer questionNumber;
    private Integer totalNumberOfQuestions;




}