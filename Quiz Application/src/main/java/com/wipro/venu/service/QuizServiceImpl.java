package com.wipro.venu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.venu.entity.Question;
import com.wipro.venu.entity.QuestionWrapper;
import com.wipro.venu.entity.Quiz;
import com.wipro.venu.entity.Response;
import com.wipro.venu.repository.QuestionRepository;
import com.wipro.venu.repository.QuizRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService{
	
	private final QuizRepository quizRepository;
	private final QuestionRepository questionRepository;

	@Override
	public Quiz createQuiz(String category, String level, String title) {
		
		
		List<Question> questions = questionRepository.findRandomQuestionByCategoryAndLevel(category, level);
		Quiz quiz = new Quiz();
		quiz.setQuizTitle(title);
		quiz.setQuestions(questions);
		
		return quizRepository.save(quiz);
		
	}

	@Override
	public List<QuestionWrapper> getQuizQuestions(Integer id) {
		
		
			
			
			Quiz quiz = quizRepository.findById(id).get();
			
			List<Question> questions = quiz.getQuestions();
			
			List list = new ArrayList<>();
			
		
			for(Question que : questions) {
				QuestionWrapper qw = new QuestionWrapper();
				
				qw.setQuestionTitle(que.getQuestionTitle());
				qw.setOption1(que.getOption1());
				qw.setOption2(que.getOption2());
				qw.setOption3(que.getOption3());
				qw.setOption4(que.getOption4());
				
				list.add(qw);
				
			}
		
		return list;
		
	}

	@Override
	public Integer calculateResult(int id, List<Response> response) {
		
		Quiz quiz = quizRepository.findById(id).get();
		
		List<Question> questions = quiz.getQuestions();
		
		int score = 0;
		
		for(Question ques: questions)
			for(Response res: response) {
				if(ques.getCorrectAnswer().equalsIgnoreCase(res.getResponse())) {
					score++;
				}
				
			}
		return score;
	}
	
	

}
