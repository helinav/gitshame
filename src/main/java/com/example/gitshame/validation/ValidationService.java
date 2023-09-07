package com.example.gitshame.validation;

import com.example.gitshame.domain.user.User;
import ee.valiit.bank30back.domain.location.Location;
import ee.valiit.bank30back.domain.user.User;
import ee.valiit.bank30back.infrastructure.exception.BusinessException;
import ee.valiit.bank30back.infrastructure.exception.DataNotFoundException;

import java.util.List;
import java.util.Optional;

import static ee.valiit.bank30back.validation.Error.*;

public class ValidationService {

    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new BusinessException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
        return optionalUser.get();
    }
}
