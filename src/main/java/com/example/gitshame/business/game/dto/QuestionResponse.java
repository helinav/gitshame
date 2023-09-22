package com.example.gitshame.business.game.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * DTO for {@link PlayerAnswer}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponse implements Serializable {

    private Integer questionId;
}