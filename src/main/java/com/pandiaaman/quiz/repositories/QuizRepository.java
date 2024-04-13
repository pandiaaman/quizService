package com.pandiaaman.quiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pandiaaman.quiz.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>{

}
