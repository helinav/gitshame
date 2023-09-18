package com.example.gitshame.domain.question;

import com.example.gitshame.business.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Question> findAllActiveQuestionsBy(Integer gameId) {
        return questionRepository.findQuestionsBy(gameId, Status.ACTIVE.getLetter());

    }
}
