package com.example.gitshame.business;

import com.example.gitshame.domain.user.role.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Resource
    private UserService userService;

    @Resource
    private UserMap


    public void login(String username, String password) {
        userService.findActiveUserBy (username, password);
        userMapper.toLoginResponse(User);

    }
}
