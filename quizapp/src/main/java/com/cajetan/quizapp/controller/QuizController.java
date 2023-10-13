package com.cajetan.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cajetan.quizapp.entities.Question;
import com.cajetan.quizapp.entities.QuestionWrapper;
import com.cajetan.quizapp.entities.Response;
import com.cajetan.quizapp.service.QuizService;


@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	QuizService quizService;;
	
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String quizTitle ){
		return quizService.createQuiz(category, numQ, quizTitle);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id){
		return quizService.getQuiz(id);
	}
	
	@PostMapping("/submit/{quizId}")
	public ResponseEntity<Integer> submit(@PathVariable Integer quizId,@RequestBody List<Response> responses){
		return quizService.calculateResult(quizId, responses);
	}

}
