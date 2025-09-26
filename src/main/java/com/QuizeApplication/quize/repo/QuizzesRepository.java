package com.QuizeApplication.quize.repo;


import com.QuizeApplication.quize.model.Quizzes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface QuizzesRepository extends JpaRepository<Quizzes, UUID> {


}
