package com.wipro.venu.service;

import java.util.List;

import com.wipro.venu.entity.QuestionWrapper;
import com.wipro.venu.entity.Quiz;
import com.wipro.venu.entity.Response;

public interface QuizService {

	Quiz createQuiz(String category, String level, String title);

	List<QuestionWrapper> getQuizQuestions(Integer id);

	Integer calculateResult(int id, List<Response> response);

		
}
