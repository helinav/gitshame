package com.example.gitshame.domain.user;

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


    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void validateUsernameIsAvailable(String username) {
        boolean userExists = userRepository.userExistsBy(username);
        ValidationService.validateUsernameIsAvailable(userExists);
    }

}
