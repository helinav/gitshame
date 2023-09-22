package com.example.gitshame.business;

import lombok.Getter;

@Getter
public enum Status {
    ACTIVE("A"),
    DEACTIVATED ("D"),
    NEXT_QUESTION ("N"),
    PENDING_QUESTION ("P"),
    COMPLETED_QUESTION ("C");

    private final String letter;

    Status(String letter) {this.letter = letter;}
}
