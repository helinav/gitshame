package com.example.gitshame.business.login.dto;

import com.example.gitshame.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * DTO for {@link User}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse implements Serializable {

    private Integer userId;
    private String roleName;
    private Integer playerId;
}