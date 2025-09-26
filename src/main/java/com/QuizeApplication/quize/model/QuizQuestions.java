package com.QuizeApplication.quize.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class QuizQuestions {
    @Id
    private UUID id;
    private int questionNo;
    private String questionType;
    private String mcsOptions;
    private String correctOption;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getQuizeId() {
        return questionNo;
    }

    public void setQuizeId(int questionNo) {
        this.questionNo = questionNo;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getMcsOptions() {
        return mcsOptions;
    }

    public void setMcsOptions(String mcsOptions) {
        this.mcsOptions = mcsOptions;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }
}
