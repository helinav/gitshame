package com.example.gitshame.validation;


import com.example.gitshame.domain.User;
import com.example.gitshame.infrastructure.exception.BusinessException;

import java.util.Optional;

import static com.example.gitshame.validation.Error.INCORRECT_CREDENTIALS;

public class ValidationService {

    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new BusinessException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
        return optionalUser.get();
    }
}

