package com.example.gitshame.domain.player.playeranswer;

import com.example.gitshame.business.gameplay.dto.PlayerAnswerRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlayerAnswerMapper {


    PlayerAnswer toPlayerAnswer(PlayerAnswerRequest playerAnswerRequest);

}