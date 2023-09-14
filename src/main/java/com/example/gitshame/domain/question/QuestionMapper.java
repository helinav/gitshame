package com.example.gitshame.domain.question;

import com.example.gitshame.business.game.dto.QuestionRequest;
import com.example.gitshame.business.game.dto.QuestionResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface QuestionMapper {



    Question toQuestion(QuestionRequest request, Integer gameId);

    @Mapping(source = "id", target = "questionId")
    QuestionResponse toQuestionResponse(Question question);
}