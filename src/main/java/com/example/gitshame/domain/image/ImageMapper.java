package com.example.gitshame.domain.image;

import com.example.gitshame.business.game.dto.QuestionRequest;
import com.example.gitshame.business.image.dto.AvatarResponse;
import com.example.gitshame.business.image.dto.AvatarRequest;
import com.example.gitshame.util.ImageConverter;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,
        imports = {ImageConverter.class})

public interface ImageMapper {

    @Mapping(constant = "A", target = "status")
    @Mapping(constant = "A", target = "type")
    Image toAvatar(AvatarRequest request);

    @Mapping(source = "id", target = "imageId")
    @Mapping(expression = "java(ImageConverter.imageToImageData(image))", target = "imageData")
    //@Mapping(source = "data", target = "imageData", qualifiedByName = "imageToImageData")
    AvatarResponse toAvatarDto(Image image);

    List<AvatarResponse> toAvatarDtos(List<Image> images);

    @Mapping(constant = "A", target = "status")
    @Mapping(constant = "Q", target = "type")
    @Mapping(source = "imageData", target = "data", qualifiedByName = "stringToByteArray")
    Image toImage(QuestionRequest request);

    @Named("stringToByteArray")
    static byte[] stringToByteArray(String imageData) {
        return ImageConverter.getBytesArrayFromImageData(imageData);
    }
}

