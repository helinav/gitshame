package com.example.gitshame.domain.answer;

import com.example.gitshame.business.game.dto.AnswerRequest;
import com.example.gitshame.domain.answer.Answer;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnswerMapper {

    Answer toAnswer (AnswerRequest answerRequest);


}