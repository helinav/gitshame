package com.example.gitshame.business.gameplay.dto;

import com.example.gitshame.domain.answer.Answer;
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
public class AnswerResponse implements Serializable {

    private Boolean isCorrect = false;
}