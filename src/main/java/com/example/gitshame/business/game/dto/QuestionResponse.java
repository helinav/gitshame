package com.example.gitshame.business.game.dto;

import com.example.gitshame.domain.question.Question;
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
public class QuestionResponse implements Serializable {
    private Integer questionId;
}