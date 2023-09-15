package com.example.gitshame.business.login;

import com.example.gitshame.business.login.dto.LoginResponse;
import com.example.gitshame.domain.player.Player;
import com.example.gitshame.domain.player.PlayerService;
import com.example.gitshame.domain.user.User;
import com.example.gitshame.domain.user.UserMapper;
import com.example.gitshame.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private PlayerService playerService;

    public LoginResponse login(String username, String password) {
        User user = userService.findActiveUserBy(username, password);
        LoginResponse loginResponse = userMapper.toLoginResponse(user);
        handlePlayerExists(user, loginResponse);
        return loginResponse;
    }

    private void handlePlayerExists(User user, LoginResponse loginResponse) {
        if ("player".equals(user.getRole().getName())) {
            Player player = playerService.getPlayer(user.getId());
            loginResponse.setPlayerId(player.getId());
        }
    }
}
