package com.QuizeApplication.quize.service;

import com.QuizeApplication.quize.dto.AddQuestionsDTO;
import com.QuizeApplication.quize.dto.CreateQuizeDTO;
import com.QuizeApplication.quize.dto.QuizQuestionResponse;
import com.QuizeApplication.quize.dto.QuizSubmitRequestDTO;
import com.QuizeApplication.quize.exception.InvalidQuestionException;
import com.QuizeApplication.quize.exception.SQLException;
import com.QuizeApplication.quize.mapper.QuestionDtoConverter;
import com.QuizeApplication.quize.model.QuizQuestions;
import com.QuizeApplication.quize.model.Quizzes;
import com.QuizeApplication.quize.repo.QuizQuestionsRepository;
import com.QuizeApplication.quize.repo.QuizSubmissionsRepository;
import com.QuizeApplication.quize.repo.QuizzesRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class QuizeControllerService {

    private final QuizzesRepository quizRespository;
    private final QuestionDtoConverter questionMapper;
    private final QuizQuestionsRepository questionsRepository;
    private final QuizSubmissionsRepository submissionsRepository;

    public QuizeControllerService(QuizzesRepository quizRespository, QuestionDtoConverter questionMapper, QuizQuestionsRepository questionsRepository, QuizSubmissionsRepository submissionsRepository) {
        this.quizRespository = quizRespository;
        this.questionMapper = questionMapper;
        this.questionsRepository = questionsRepository;
        this.submissionsRepository = submissionsRepository;
    }

    /// creates quiz and returns quizId
    public String createQuize(CreateQuizeDTO dto) {
        /// creates new Quizzes objected
        Quizzes quiz = new Quizzes();
        quiz.setCreatedAt(LocalDateTime.now());
        quiz.setCreatorUsername(dto.getCreator());
        quiz.setQuizeTitle(dto.getQuizTitle());
        Quizzes response = quizRespository.save(quiz);

        return response.getId().toString();

    }

    /// method gets all the quzzes from repo
    public List<Quizzes> getAllQuizzes() {

        return quizRespository.findAll();

    }

    /// adds questions to specific quiz
    public boolean addQuestionsToQuiz(String id, List<AddQuestionsDTO> dto) {

        /// throws exception if dto is null
        if(dto.isEmpty()){
            throw new InvalidQuestionException("Please Add questions ! ");
        }

        List<QuizQuestions> questions;
        /// throws exception if question with id not found
        if(!quizRespository.existsById(UUID.fromString(id))){
            throw new SQLException("Question not found with Id : "+id);
        }

        /// maps to list of QuizQuestions from dto
        questions = questionMapper.maptoQuizQuestionsList(id, dto);

        List<QuizQuestions> response = questionsRepository.saveAll(questions);

        return !response.isEmpty();// return false if not  questions added
    }

    /// get quiz questions with id
    public List<QuizQuestionResponse> getQuizById(String quizId) {

        /// checks if quiz with id exists or not
        if(!quizRespository.existsById(UUID.fromString(quizId))){
            throw new SQLException("No quiz found with Id : "+quizId);
        }


        return questionMapper.
                maptoQuizeQuestinResponseDTOList(
                        questionsRepository
                                .findAllByQuizIdOrderByQuestionNo(UUID.fromString(quizId)));


    }


    /// calculates result based on submission anser of user
    public HashMap<String, String> getResult(String quizId, List<QuizSubmitRequestDTO> dto) {
        HashMap<String, String> result = new HashMap<>();
        /// checks if quiz with id exists or not
        if(!quizRespository.existsById(UUID.fromString(quizId))){
            throw new SQLException("No quiz found with Id : "+quizId);
        }

        int score = 0;
        int outOf = questionsRepository.countByQuizId(UUID.fromString(quizId));

        /// interates through all asnwers to get score
        for(QuizSubmitRequestDTO answer : dto ){
            Optional<QuizQuestions> question = questionsRepository.findById(UUID.fromString(answer.getQuestionId()));

            /// sets dummy ans if user haven't sent
            if(answer.getSelected()==null){
                answer.setSelected("");
            }
            // checks if questin found or not
            if(question.isEmpty()){
                throw new SQLException("No question with Id "+answer.getQuestionId());
            }

            if(question.get().getQuestionType().equalsIgnoreCase("descriptive")){
                continue;
            }


            /// if the options of user and correct option of DB matches count is increased
            if(answer.getSelected().trim().equalsIgnoreCase(question.get().getCorrectOption().trim())){
                score++;
            }

        }

        result.put("Your Score", String.valueOf(score));
        result.put("Total ", String.valueOf(outOf));

        return result;
    }

    ///
}
