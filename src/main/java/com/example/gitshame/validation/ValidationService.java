package com.example.gitshame.validation;


import com.example.gitshame.domain.user.User;
import com.example.gitshame.infrastructure.exception.BusinessException;

import java.util.Optional;

import static com.example.gitshame.validation.Error.*;

public class ValidationService {

    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new BusinessException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
        return optionalUser.get();
    }

    public static void validateUsernameIsAvailable(boolean userExists) {
        if (userExists) {
            throw new BusinessException(USERNAME_ALREADY_EXISTS.getMessage(), USERNAME_ALREADY_EXISTS.getErrorCode());
        }
    }

    public static void validateEmailIsAvailable(boolean emailExists) {
        if (emailExists) {
            throw new BusinessException(EMAIL_ALREADY_EXISTS.getMessage(), EMAIL_ALREADY_EXISTS.getErrorCode());
        }
    }

    public static void validateGameNameIsAvailable(boolean gameExists) {
        if (gameExists) {
            throw new BusinessException(GAME_NAME_ALREADY_EXISTS.getMessage(), GAME_NAME_ALREADY_EXISTS.getErrorCode());
        }
    }
}

