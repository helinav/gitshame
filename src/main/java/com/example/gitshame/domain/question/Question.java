package com.example.gitshame.domain.question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "question")
public class Question {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "text", nullable = false)
    private String text;

    @Size(max = 255)
    @NotNull
    @Column(name = "answer_explanation", nullable = false)
    private String answerExplanation;

    @NotNull
    @Column(name = "time_limit", nullable = false)
    private Integer timeLimit;

}