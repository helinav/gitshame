package com.example.gitshame.domain.player;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Player}
 */
@Value
public class PlayerDto implements Serializable {

    Integer id;
    Integer imageId;
    Integer userId;
    @NotNull
    @Size(max = 255)
    String email;
}