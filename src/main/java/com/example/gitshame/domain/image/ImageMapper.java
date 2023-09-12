package com.example.gitshame.domain.image;

import com.example.gitshame.business.image.dto.AvatarRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ImageMapper {

    @Mapping(constant = "A", target = "status")
    @Mapping(constant = "A", target = "type")
    Image toAvatar (AvatarRequest request);

}