package com.example.gitshame.domain.game;

import com.example.gitshame.business.game.dto.GameDto;
import com.example.gitshame.business.game.dto.GameResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface GameMapper {

    @Mapping(source = "id", target = "gameId")
    GameResponse toGameResponse(Game game);

    List <GameDto> toGameDtos(List<Game> games);
}