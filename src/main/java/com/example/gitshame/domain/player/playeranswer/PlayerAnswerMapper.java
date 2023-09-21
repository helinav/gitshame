package com.example.gitshame.domain.player.playeranswer;

import com.example.gitshame.business.gameplay.dto.AnswerResponse;
import com.example.gitshame.business.gameplay.dto.StartAnswerRequest;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PlayerAnswerMapper {



    PlayerAnswer toPlayerAnswer(StartAnswerRequest startAnswerRequest);


    AnswerResponse toAnswerResponse(PlayerAnswer playerAnswer);
}