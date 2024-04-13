package com.pandiaaman.quiz.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pandiaaman.quiz.entities.Question;

//@FeignClient(url = "http://localhost:8082", value="Question-Client")
@FeignClient(name = "QUESTION-SERVICE")
public interface QuestionClient {

	@GetMapping("/question/quiz/{quizId}")
	List<Question> getQuestionsOfQuiz(@PathVariable Long quizId);
}
