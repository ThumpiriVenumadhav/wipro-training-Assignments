package com.wipro.venu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.venu.entity.Question;
import com.wipro.venu.service.QuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/question")
public class QuestionController {
	
	@Autowired
	private final QuestionService questionService;
	
	@GetMapping("/getquestions")
	public List<Question> getQuestions() {
		return questionService.getQuestions();
	}
	
	@GetMapping("/getquestion/{id}")
	public Question getQuestion(@PathVariable int id) {
		return questionService.getQuestion(id);
	}
	
	@PostMapping("/create")
	public Question createQuestion( @Valid @RequestBody Question question) {
		return questionService.createQuestion(question);
	}
	
	@PutMapping("/update/{id}")
	public Question updateQuestion(@RequestBody Question question,@PathVariable int id) {
		return questionService.updateQuestion(question,id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String  deleteQuestion(@PathVariable int id) {
		return questionService.deleteQuestion(id);
	}
	
	@PatchMapping("/updatepatch/{id}")
	public Question updateQuestion(@PathVariable int id,@RequestBody Question question) {
		return questionService.patchUpdate(id,question);
	}
	
	 @GetMapping("/getQuestionsInPages")
	    public Page<Question> getAllQuestionsByPage(Pageable pageable){
	    	
	    	return questionService.getQuestionsByPage(pageable);
	    }
	    

}
