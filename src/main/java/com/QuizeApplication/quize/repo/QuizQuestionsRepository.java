package com.QuizeApplication.quize.repo;

import com.QuizeApplication.quize.model.QuizQuestions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface QuizQuestionsRepository extends JpaRepository<QuizQuestions, UUID> {

    List<QuizQuestions> findAllByQuizIdOrderByQuestionNo(UUID id);
    int countByQuizId(UUID quizId);
}
