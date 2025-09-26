package com.QuizeApplication.quize.service;

import com.QuizeApplication.quize.model.Quizzes;
import com.QuizeApplication.quize.repo.QuizzesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuizzesRepoService {

    private QuizzesRepository repo;

    public QuizzesRepoService(QuizzesRepository repo) {
        this.repo = repo;
    }


    public Optional<Quizzes> save(Quizzes quiz) {
        return Optional.of(repo.save(quiz));
    }
}
