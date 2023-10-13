package com.cajetan.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cajetan.quizapp.entities.Question;
import com.cajetan.quizapp.entities.Test;
import com.cajetan.quizapp.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("/allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category) {
		return questionService.getQuestionsByCategory(category);
	}
	
	@PostMapping("/addQuestion")
	public ResponseEntity<String> addQuestion(@RequestBody Question q) {
		return questionService.addQuestion(q);
	}
	
	@PostMapping("/addTest")
	public void addTest(@RequestBody Test q) {
		questionService.addTest(q);
	}

}
