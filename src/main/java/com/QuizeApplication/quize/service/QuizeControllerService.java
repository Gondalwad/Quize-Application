package com.QuizeApplication.quize.service;

import com.QuizeApplication.quize.dto.AddQuestionsDTO;
import com.QuizeApplication.quize.dto.CreateQuizeDTO;
import com.QuizeApplication.quize.exception.InvalidQuestionException;
import com.QuizeApplication.quize.exception.SQLException;
import com.QuizeApplication.quize.mapper.QuestionDtoToQuizQuestions;
import com.QuizeApplication.quize.model.QuizQuestions;
import com.QuizeApplication.quize.model.Quizzes;
import com.QuizeApplication.quize.repo.QuizQuestionsRepository;
import com.QuizeApplication.quize.repo.QuizzesRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class QuizeControllerService {

    private final QuizzesRepository repoService;
    private final  QuestionDtoToQuizQuestions questionMapper;
    private final QuizQuestionsRepository questionsRepository;

    public QuizeControllerService(QuizzesRepository repoService, QuestionDtoToQuizQuestions questionMapper, QuizQuestionsRepository questionsRepository) {
        this.repoService = repoService;
        this.questionMapper = questionMapper;
        this.questionsRepository = questionsRepository;
    }


    /// creates quiz and returns quizId
    public String createQuize(CreateQuizeDTO dto) {
        /// creates new Quizzes objected
        Quizzes quiz = new Quizzes();
        quiz.setCreatedAt(LocalDateTime.now());
        quiz.setCreatorUsername(dto.getCreator());
        quiz.setQuizeTitle(dto.getQuizTitle());
        Quizzes response = repoService.save(quiz);

        return response.getId().toString();

    }

    /// method gets all the quzzes from repo
    public List<Quizzes> getAllQuizzes() {

        return repoService.findAll();

    }

    /// adds questions to specific quiz
    public boolean addQuestionsToQuiz(String id, List<AddQuestionsDTO> dto) {

        /// throws exception if dto is null
        if(dto.isEmpty()){
            throw new InvalidQuestionException("Please Add questions ! ");
        }

        List<QuizQuestions> questions;
        /// throws exception if question with id not found
        if(!repoService.existsById(UUID.fromString(id))){
            throw new SQLException("Question not found with Id : "+id);
        }

        /// maps to list of QuizQuestions from dto
        questions = questionMapper.maptoList(id, dto);

        List<QuizQuestions> response = questionsRepository.saveAll(questions);

        return !response.isEmpty();// return false if not  questions added
    }

    ///
}
