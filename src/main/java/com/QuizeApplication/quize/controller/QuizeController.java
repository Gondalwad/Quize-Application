package com.QuizeApplication.quize.controller;

import com.QuizeApplication.quize.dto.AddQuestionsDTO;
import com.QuizeApplication.quize.dto.CreateQuizeDTO;
import com.QuizeApplication.quize.dto.QuizQuestionResponse;
import com.QuizeApplication.quize.dto.QuizSubmitRequestDTO;
import com.QuizeApplication.quize.model.Quizzes;
import com.QuizeApplication.quize.service.QuizeControllerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class QuizeController {

    private QuizeControllerService controllerService;

    public QuizeController(QuizeControllerService controllerService) {
        this.controllerService = controllerService;
    }

    @PostMapping("/create")
    public ResponseEntity<HashMap<String, String>> createQuize(@RequestBody @Validated CreateQuizeDTO dto){
        String resultId = controllerService.createQuize(dto);

        /// return status 500 if not created
        if(resultId.trim().equalsIgnoreCase("")){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        /// return status 200 if quiz is created
        HashMap<String, String> response = new HashMap<>();
        response.put("Quiz Id",resultId);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /// to get all quizzes
    @GetMapping("/getAll")
    public ResponseEntity<List<Quizzes>> getAllquizzes(){

        return ResponseEntity.ok().body(controllerService.getAllQuizzes());
    }

    /// get one question of oneQuiz
    @GetMapping("/getOne/{quizId}")
    public ResponseEntity<List<QuizQuestionResponse>> getOneQuiz(@PathVariable("quizId") String quizId){
       List<QuizQuestionResponse> questions =  controllerService.getQuizById(quizId);

       return ResponseEntity.status(HttpStatus.OK).body(questions);
    }

    /// to add questions to quiz
    @PostMapping("addQuestions/{quizId}")
    public ResponseEntity<List<AddQuestionsDTO>> addQuestionsToQuiz(@PathVariable("quizId") String id, @RequestBody @Validated List< AddQuestionsDTO> dto){

        boolean result = controllerService.addQuestionsToQuiz(id, dto);

        return result ? ResponseEntity.status(HttpStatus.CREATED).body(dto) : ResponseEntity.badRequest().build();

    }

    /// to get result of submission
    @PostMapping("/submitQuiz/{quizId}")
    public ResponseEntity<HashMap<String,String>> getSubmissionResult(@PathVariable("quizId") String quizId, @RequestBody @Validated List<QuizSubmitRequestDTO> dto){


        HashMap<String,String> result = controllerService.getResult(quizId, dto);

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


}
