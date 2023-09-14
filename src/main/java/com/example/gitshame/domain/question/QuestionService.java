package com.example.gitshame.domain.question;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Resource
    private QuestionRepository questionRepository;
    public void saveQuestion(Question question) {
        questionRepository.save(question);
    }

    public Question getQuestion(Integer questionId) {
        return questionRepository.getReferenceById(questionId);
    }
}
