package com.example.gitshame.validation;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Vale kasutajanimi või parool", 111),

    USERNAME_ALREADY_EXISTS ("Kasutajanimi on juba kasutusel",222),

    EMAIL_ALREADY_EXISTS ("Sellise emaili aadressiga on juba aktiivne kasutaja",223);

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
    }
