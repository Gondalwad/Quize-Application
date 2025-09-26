package com.QuizeApplication.quize.repo;

import com.QuizeApplication.quize.model.QuizSubmissions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuizSubmissionsRepository extends JpaRepository<QuizSubmissions, UUID> {
}
