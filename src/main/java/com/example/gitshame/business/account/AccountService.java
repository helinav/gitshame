package com.example.gitshame.business.account;

import com.example.gitshame.business.account.dto.AccountRequest;
import com.example.gitshame.domain.image.Image;
import com.example.gitshame.domain.image.ImageService;
import com.example.gitshame.domain.player.Player;
import com.example.gitshame.domain.player.PlayerService;
import com.example.gitshame.domain.user.User;
import com.example.gitshame.domain.user.UserMapper;
import com.example.gitshame.domain.user.UserService;
import com.example.gitshame.domain.user.role.Role;
import com.example.gitshame.domain.user.role.RoleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleService roleService;

    @Resource
    private UserService userService;

    @Resource
    private ImageService imageService;
    
    @Resource
    private PlayerService playerService;

    public void addAccount(AccountRequest request) {
        userService.validateUsernameIsAvailable(request.getUsername());
        playerService.validateEmailIsAvailabe(request.getEmail());
        Role role = roleService.getRolePlayer();
        User user = createAndSaveUser(request, role);
        createAndSavePlayer(request, user);
    }
    
    private User createAndSaveUser(AccountRequest request, Role role) {
        User user = userMapper.toUser(request);
        user.setRole(role);
        userService.saveUser(user);
        return user;
    }
    
    private void createAndSavePlayer(AccountRequest request, User user) {
        Image image = imageService.getImageBy(request.getImageId());
        Player player = new Player();
        player.setEmail(request.getEmail());
        player.setImage(image);
        player.setUser(user);
        playerService.savePlayer(player);
    }

}

