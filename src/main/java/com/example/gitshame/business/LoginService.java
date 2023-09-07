package com.example.gitshame.business;

import com.example.gitshame.business.dto.LoginResponse;
import com.example.gitshame.domain.User;
import com.example.gitshame.domain.UserMapper;
import com.example.gitshame.domain.user.role.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;


    public LoginResponse login(String username, String password) {
        User user =  userService.findActiveUserBy (username, password);
        return userMapper.toLoginResponse(user);

    }
}
