package com.QuizeApplication.quize.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler {

    /// this method is avoid uncessary error display to user
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HashMap<String, String>> handleValidationException(MethodArgumentNotValidException ex){
        HashMap<String, String> response = new HashMap<>();
        ///get binfing result and sets to response as key value
        ex.getBindingResult().getFieldErrors().forEach(e->response.put(e.getField(), e.getDefaultMessage()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /// method to handle sql related exception
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<String> handleSqlException(SQLException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    /// method to handle exception for invalid questions
    @ExceptionHandler(InvalidQuestionException.class)
    public ResponseEntity<String> handleInvalidQuestionException(InvalidQuestionException ex){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
