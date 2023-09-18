package com.example.gitshame.domain.player.playergame;

import com.example.gitshame.business.gameplay.dto.PlayerGameRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlayerGameMapper {


    @Mapping(constant = "A", target="status")
    PlayerGame toPlayerGame(PlayerGameRequest playerGameRequest);


}