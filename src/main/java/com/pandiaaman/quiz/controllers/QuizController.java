package com.pandiaaman.quiz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pandiaaman.quiz.entities.Quiz;
import com.pandiaaman.quiz.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	private QuizService quizService;

	public QuizController(QuizService quizService) {
		super();
		this.quizService = quizService;
	}
	
	
	//create
	@PostMapping("")
	public Quiz createQuiz(@RequestBody Quiz quiz) {
		return quizService.addQuiz(quiz);
	}
	
	//getall
	@GetMapping("")
	public List<Quiz> getAllQuiz(){
		return quizService.getAllQuiz();
	}
	
	//get
	@GetMapping("/{id}")
	public Quiz getQuiz(@PathVariable Long id) {
		return quizService.getQuiz(id);
	}
}
