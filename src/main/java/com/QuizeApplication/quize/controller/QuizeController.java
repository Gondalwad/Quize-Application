package com.QuizeApplication.quize.controller;

import com.QuizeApplication.quize.dto.CreateQuizeDTO;
import com.QuizeApplication.quize.model.Quizzes;
import com.QuizeApplication.quize.service.QuizeControllerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class QuizeController {

    private QuizeControllerService controllerService;

    public QuizeController(QuizeControllerService controllerService) {
        this.controllerService = controllerService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createQuize(@RequestBody @Validated CreateQuizeDTO dto){
        boolean result = controllerService.createQuize(dto);

        /// return status 500 if not created
        if(!result){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        /// return status 200 if quiz is created
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Quizzes>> getAllquizzes(){

        return ResponseEntity.ok().body(controllerService.getAllQuizzes());
    }
}
