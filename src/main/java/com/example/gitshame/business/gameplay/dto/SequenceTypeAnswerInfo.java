package com.example.gitshame.business.gameplay.dto;

import com.example.gitshame.domain.answer.Answer;
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
public class SequenceTypeAnswerInfo implements Serializable {
    private Integer answerId;
    private String text;
    private Integer sequence;
    private Boolean isSelected =false;
}