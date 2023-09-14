package com.example.gitshame.business.image.dto;

import com.example.gitshame.domain.image.Image;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Image}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvatarDto implements Serializable {
    private Integer imageId;
    private String imageData;
}