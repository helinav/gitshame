package com.example.gitshame.business.image.dto;

import com.example.gitshame.domain.image.Image;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Image}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class AvatarRequest implements Serializable {
    @NotNull
    private String imageData;
    @NotNull
    private String status;
    @NotNull
    private String type;
}