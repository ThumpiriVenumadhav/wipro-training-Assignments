package com.wipro.venu.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.venu.entity.Question;

public interface QuestionService {

	List<Question> getQuestions();

	Question getQuestion(int id);

	Question createQuestion(Question question);

	Question updateQuestion(Question question, int id);

	String deleteQuestion(int id);

	Question patchUpdate(int id, Question question);

	Page<Question> getQuestionsByPage(Pageable pageable);
	
	

}
