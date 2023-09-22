package com.example.gitshame.domain.player.playergame;

import com.example.gitshame.business.gameplay.dto.LeaderboardResponse;
import com.example.gitshame.business.gameplay.dto.NewGameRequest;
import com.example.gitshame.business.gameplay.dto.PlayerGameDto;
import com.example.gitshame.util.TimeConverter;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {TimeConverter.class})
public interface PlayerGameMapper {


    @Mapping(constant = "A", target = "status")
    @Mapping(constant = "0", target = "strikeCount")
    @Mapping(constant = "0", target = "score")
    @Mapping(expression = "java(TimeConverter.getEstonianTimeZoneInstant())", target = "startTime")
    PlayerGame toPlayerGame(NewGameRequest newGameRequest);

    @Mapping(source = "id", target = "playerGameId")
    PlayerGameDto toPlayerGameDto(PlayerGame playerGame);



    @Mapping(source = "player.user.username", target = "username")
    LeaderboardResponse toLeaderboardResponse(PlayerGame playerGame);

    List<LeaderboardResponse> toLeaderBoardResponses (List<PlayerGame> leaderboardInfos);

}