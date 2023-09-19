package com.example.gitshame.domain.answer;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    @Resource
    private AnswerRepository answerRepository;

    public void saveAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    public List<Answer> getAnswers(Integer questionId) {
        return answerRepository.getAnswersBy(questionId);

    }

    public Answer getAnswer(Integer questionId) {
        return answerRepository.getAnswerBy(questionId);
    }
}
