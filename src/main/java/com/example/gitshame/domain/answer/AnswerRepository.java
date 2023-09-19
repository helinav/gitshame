package com.example.gitshame.domain.answer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    @Query("select a from Answer a where a.question.id = ?1")
    List<Answer> getAnswersBy(Integer id);

    @Query("select a from Answer a where a.question.id = ?1")
    Answer getAnswerBy(Integer id);




//    @Query("select a from Answer a where a.question.id = ?1")
//    Answer answerByQuestion(Integer id);


}

