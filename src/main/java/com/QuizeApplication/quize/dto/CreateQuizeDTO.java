package com.QuizeApplication.quize.dto;


import jakarta.validation.constraints.NotBlank;

public class CreateQuizeDTO {
    @NotBlank
    private String quizTitle;
    private String creator;

    public @NotBlank String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(@NotBlank String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
