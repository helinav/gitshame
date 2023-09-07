package com.example.gitshame.domain.user.role;

import com.example.gitshame.domain.User;
import com.example.gitshame.domain.user.UserRepository;
import com.example.gitshame.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import com.example.gitshame.business.Status;


import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User findActiveUserBy(String username, String password) {
        Optional<User> optionalUser = userRepository.findUserBy(username, password, Status.ACTIVE.getLetter());
        return ValidationService.getValidUser(optionalUser);
    }


}
