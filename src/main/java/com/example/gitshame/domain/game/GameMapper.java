package com.example.gitshame.domain.game;

import com.example.gitshame.business.game.dto.GameResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface GameMapper {

    @Mapping(source = "id", target = "gameId")
    GameResponse toGameResponse(Game game);

}