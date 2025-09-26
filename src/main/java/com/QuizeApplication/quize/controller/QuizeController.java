package com.QuizeApplication.quize.controller;

import com.QuizeApplication.quize.dto.CreateQuizeDTO;
import com.QuizeApplication.quize.service.QuizeControllerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
