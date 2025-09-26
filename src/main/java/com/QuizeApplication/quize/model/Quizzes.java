package com.QuizeApplication.quize.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Quizzes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String quizeTitle;
    private String creatorUsername;
    private LocalDateTime createdAt;

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatorUsername() {
        return creatorUsername;
    }

    public void setCreatorUsername(String creatorUsername) {
        this.creatorUsername = creatorUsername;
    }
}
