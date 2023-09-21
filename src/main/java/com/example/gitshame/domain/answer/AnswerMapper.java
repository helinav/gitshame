package com.example.gitshame.domain.answer;

import com.example.gitshame.business.game.dto.AnswerRequest;
import com.example.gitshame.business.gameplay.dto.MultipleChoiceAnswerInfo;
import com.example.gitshame.business.gameplay.dto.SequenceTypeAnswerInfo;
import com.example.gitshame.business.gameplay.dto.TextBoxAnswerInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface AnswerMapper {

    Answer toAnswer(AnswerRequest answerRequest);

    @Mapping(source = "id", target = "answerId")
    MultipleChoiceAnswerInfo toSelectResponse(Answer answer);

    List<MultipleChoiceAnswerInfo> toSelectResponse(List<Answer> answers);

    @Mapping(source = "id", target = "answerId")
    TextBoxAnswerInfo toTextBoxResponse(Answer answer);

    @Mapping(source = "id", target = "answerId")
    SequenceTypeAnswerInfo toSequenceResponse (Answer answer);

    List<SequenceTypeAnswerInfo> toSequenceResponses (List<Answer> answers);

}