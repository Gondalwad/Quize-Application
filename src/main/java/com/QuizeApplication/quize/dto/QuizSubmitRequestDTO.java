package com.QuizeApplication.quize.dto;

import jakarta.validation.constraints.Size;

public class QuizSubmitRequestDTO {

    private String questionId;
    private String selected;
    @Size(max = 200, message = "Max 200 chars are allows")
    private String text;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
