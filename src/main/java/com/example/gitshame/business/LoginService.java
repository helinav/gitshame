package com.example.gitshame.business;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
    public void login(String username, String password) {
        userService.findActiveUsersBy(username, password);
    }
}
