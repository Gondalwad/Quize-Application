package com.QuizeApplication.quize.service;

import com.QuizeApplication.quize.dto.CreateQuizeDTO;
import com.QuizeApplication.quize.model.Quizzes;
import com.QuizeApplication.quize.repo.QuizzesRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class QuizeControllerService {

    private QuizzesRepository repoService;

    public QuizeControllerService(QuizzesRepository repoService) {
        this.repoService = repoService;
    }


    public boolean createQuize(CreateQuizeDTO dto) {
        /// creates new Quizzes objected
        Quizzes quiz = new Quizzes();
        quiz.setCreatedAt(LocalDateTime.now());
        quiz.setCreatorUsername(dto.getCreator());
        quiz.setQuizeTitle(dto.getQuizTitle());
        Quizzes response = repoService.save(quiz);

        return response.getId()!=null;

    }

    /// method gets all the quzzes from repo
    public List<Quizzes> getAllQuizzes() {

        return repoService.findAll();
    }
}
