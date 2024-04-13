package com.pandiaaman.quiz.services;

import java.util.List;

import com.pandiaaman.quiz.entities.Quiz;

public interface QuizService {

	
	Quiz addQuiz(Quiz quiz);
	
	List<Quiz> getAllQuiz();
	
	Quiz getQuiz(Long id);
}
