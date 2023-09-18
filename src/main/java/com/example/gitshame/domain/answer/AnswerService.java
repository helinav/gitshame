package com.example.gitshame.domain.answer;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Resource
    private AnswerRepository answerRepository;

    public void saveAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    public Answer getAnswer(Integer answerId) {
        return answerRepository.getReferenceById(answerId);
    }
}
