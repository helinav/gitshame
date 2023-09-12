package com.example.gitshame.business.image.dto;

import com.example.gitshame.domain.image.Image;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Image}
 */
@Data
@AllArgsConstructor

public class AvatarRequest implements Serializable {
    @NotNull
    byte[] data;
    @NotNull
    String status;
    @NotNull
    String type;
}