package com.example.gitshame.business.login.dto;

import com.example.gitshame.domain.player.Player;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Player}
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto implements Serializable {

    private Integer id;
    private Integer imageId;
    private Integer userId;
    @NotNull
    @Size(max = 255)
    private String email;
}