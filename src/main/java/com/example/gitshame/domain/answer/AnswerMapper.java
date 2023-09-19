package com.example.gitshame.domain.answer;

import com.example.gitshame.business.game.dto.AnswerRequest;
import com.example.gitshame.business.gameplay.dto.CheckboxResponse;
import com.example.gitshame.business.gameplay.dto.SelectResponse;
import com.example.gitshame.business.gameplay.dto.SequenceResponse;
import com.example.gitshame.business.gameplay.dto.TextBoxResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnswerMapper {

    Answer toAnswer(AnswerRequest answerRequest);

    @Mapping(source = "id", target = "answerId")
    @Mapping(constant = "false", target = "isSelected")
    SelectResponse toRadioResponse(Answer answer);

    List<SelectResponse> toRadioResponses(List<Answer> answers);

    List<CheckboxResponse> toCheckboxResponses(List<Answer> answers);

    @Mapping(source = "id", target = "answerId")
    TextBoxResponse toTextBoxResponse(Answer answer);



    @Mapping(constant = "false", target = "isSelected")
    @Mapping(source = "id", target = "answerId")
    SequenceResponse toDto (Answer answer);

    List<SequenceResponse> toSequenceResponses (List<Answer> answers);

}