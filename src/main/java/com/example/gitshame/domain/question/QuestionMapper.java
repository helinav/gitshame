package com.example.gitshame.domain.question;

import com.example.gitshame.business.game.dto.QuestionRequest;
import com.example.gitshame.business.game.dto.QuestionResponse;
import com.example.gitshame.business.gameplay.dto.QuestionInfo;
import com.example.gitshame.util.ImageConverter;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, imports = {ImageConverter.class})
public interface QuestionMapper {

    @Mapping(constant="A", target = "status")
    Question toQuestion(QuestionRequest request);

    @Mapping(source = "id", target = "questionId")
    QuestionResponse toQuestionResponse(Question question);

    @Mapping(expression = "java(ImageConverter.imageToImageData(question.getImage()))", target = "imageData")
    @Mapping(source = "id", target = "questionId")
    @Mapping(source = "text", target = "questionText")
    @Mapping(source = "type.name", target = "typeName")
    QuestionInfo toQuestionInfo(Question question);

}