package com.pandiaaman.quiz.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pandiaaman.quiz.entities.Quiz;
import com.pandiaaman.quiz.repositories.QuizRepository;
import com.pandiaaman.quiz.services.QuestionClient;
import com.pandiaaman.quiz.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService{

	
	private QuizRepository quizRepository;	
	
	private QuestionClient questionClient;
	
	public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
		super();
		this.quizRepository = quizRepository;
		this.questionClient = questionClient;
	}

	@Override
	public Quiz addQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return quizRepository.save(quiz);
	}

	@Override
	public List<Quiz> getAllQuiz() {
		// TODO Auto-generated method stub
		List<Quiz> quizes =   quizRepository.findAll();
		for(Quiz quiz : quizes) {
			quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getQuizId()));
		}
		return quizes; 
	}

	@Override
	public Quiz getQuiz(Long id) {
		// TODO Auto-generated method stub
		Quiz quiz =  quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
		
		quiz.setQuestions(questionClient.getQuestionsOfQuiz(quiz.getQuizId()));
		
		return quiz;
				
	}

}
