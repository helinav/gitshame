package com.example.gitshame.business;

import lombok.Getter;

@Getter
public enum Status {
    ACTIVE("A"),
    DEACTIVATED ("D");

    private final String letter;

    Status(String letter) {this.letter = letter;}
}
