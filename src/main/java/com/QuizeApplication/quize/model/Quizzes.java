package com.QuizeApplication.quize.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Quizzes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String quizeTitle;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getQuizeTitle() {
        return quizeTitle;
    }

    public void setQuizeTitle(String quizeTitle) {
        this.quizeTitle = quizeTitle;
    }

}
