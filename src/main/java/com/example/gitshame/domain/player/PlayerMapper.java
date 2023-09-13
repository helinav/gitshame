package com.example.gitshame.domain.player;

import com.example.gitshame.business.login.dto.PlayerDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlayerMapper {
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "imageId", target = "image.id")
    Player toEntity(PlayerDto playerDto);

    @InheritInverseConfiguration(name = "toEntity")
    PlayerDto toDto(Player player);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Player partialUpdate(PlayerDto playerDto, @MappingTarget Player player);
}