package com.wipro.venu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.venu.entity.Question;
import com.wipro.venu.exceptions.QUESTION_NOT_FOUND_EXCEPTION;
import com.wipro.venu.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public List<Question> getQuestions() {
		return questionRepository.findAll();
	}

	@Override
	public Question getQuestion(int id) {
		return questionRepository.findById(id).orElseThrow(() -> new QUESTION_NOT_FOUND_EXCEPTION("question not found"));
	}

	@Override
	public Question createQuestion(Question question) {
		return questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question, int id) {
		Question question2 = getQuestion(id);
		
		question2.setQuestionTitle(question.getQuestionTitle());
		question2.setCategory(question.getCategory());
		question2.setOption1(question.getOption1());
		question2.setOption2(question.getOption2());
		question2.setOption3(question.getOption3());
		question2.setOption4(question.getOption4());
		question2.setDifficulty(question.getDifficulty());
		
		
		
		return questionRepository.save(question2);
	}

	@Override
	public String deleteQuestion(int id) {
		questionRepository.deleteById(id);
		return "deleted successfully";
	}

	@Override
	public Question patchUpdate(int id, Question question) {
		
		Question question2 = getQuestion(id);
		
		if(question.getQuestionTitle() != null) {
			question2.setQuestionTitle(question.getQuestionTitle());
		}
		if(question.getCategory() != null) {
			question2.setCategory(question.getCategory());
		}
		if(question.getDifficulty() != null) {
			question2.setDifficulty(question.getDifficulty());
		}
		if(question.getOption1() != null) {
			question2.setOption1(question.getOption1());
		}
		if(question.getOption2() != null) {
			question2.setOption2(question.getOption2());
		}
		if(question.getOption3() != null) {
			question2.setOption3(question.getOption3());
		}
		if(question.getOption4() != null) {
			question2.setOption4(question.getOption4());
		}
		if(question.getCorrectAnswer() != null) {
			question2.setCorrectAnswer(question.getCorrectAnswer());
		}
		
		return questionRepository.save(question2);
	}

	@Override
	public Page<Question> getQuestionsByPage(Pageable pageable) {
		return questionRepository.findAll(pageable);
	}

	

}
