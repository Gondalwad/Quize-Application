package com.QuizeApplication.quize.dto;

import java.util.HashMap;

public class QuizQuestionResponse {

    private String questionId;
    private String quizId;
    private int questionNo;
    private String Question;
    private String questionType;
    private HashMap<String,String> mcqOptions;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
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
}
