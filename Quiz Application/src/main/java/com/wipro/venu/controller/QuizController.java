package com.wipro.venu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.venu.entity.QuestionWrapper;
import com.wipro.venu.entity.Quiz;
import com.wipro.venu.entity.Response;
import com.wipro.venu.service.QuizService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/quiz")
@Slf4j
public class QuizController {
	
	private final QuizService quizService;
	
	@PostMapping("/create")
	public Quiz createQuiz(
			@RequestParam String category,
			@RequestParam String level,
			@RequestParam String title) {
		log.info("creating a new quiz and control in control layer");
		return quizService.createQuiz(category,level,title);
	}

	@GetMapping("/start/{id}")
	public List<QuestionWrapper> getQuestions(@PathVariable Integer id){
		return quizService.getQuizQuestions(id);
	}
	
	@GetMapping("/submit/{id}")
	public Integer submitQuiz(@PathVariable int id,@RequestBody List<Response> response) {
		return quizService.calculateResult(id,response);
	}
}
