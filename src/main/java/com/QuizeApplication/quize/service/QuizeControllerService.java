package com.QuizeApplication.quize.service;

import com.QuizeApplication.quize.dto.CreateQuizeDTO;
import com.QuizeApplication.quize.model.Quizzes;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class QuizeControllerService {

    private QuizzesRepoService repoService;

    public QuizeControllerService(QuizzesRepoService repoService) {
        this.repoService = repoService;
    }


    public boolean createQuize(CreateQuizeDTO dto) {
        Quizzes quiz = new Quizzes();
        quiz.setCreatedAt(LocalDateTime.now());
        quiz.setCreatorUsername(dto.getCreator());
        quiz.setQuizeTitle(dto.getQuizTitle());

        Optional<Quizzes> response = repoService.save(quiz);

        return response.isPresent();

    }
}
