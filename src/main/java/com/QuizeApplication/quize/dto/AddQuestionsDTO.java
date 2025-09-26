package com.QuizeApplication.quize.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.HashMap;

public class AddQuestionsDTO {
    @NotBlank (message = "Please check if you included appropriate question No")
    private int questionNo;
    @NotBlank(message = "Please check if you added type either 'MCQ' or 'Descriptive'")
    private String questionType;
    @NotBlank(message = "Question Text is required.")
    private String questionText;
    private HashMap<String,String> mcqOptions;
    private String correctOption;

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public HashMap<String, String> getMcqOptions() {
        return mcqOptions;
    }

    public void setMcqOptions(HashMap<String, String> mcqOptions) {
        this.mcqOptions = mcqOptions;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }

    public @NotBlank(message = "Question Text is required.") String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(@NotBlank(message = "Question Text is required.") String questionText) {
        this.questionText = questionText;
    }
}
