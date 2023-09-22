package com.example.gitshame.domain.question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    @Query("select q from Question q where q.game.id = ?1 and q.status = ?2")
    List<Question> findQuestionsBy(Integer gameId, String status);
}