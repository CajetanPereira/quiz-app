package com.cajetan.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cajetan.quizapp.entities.Question;
import com.cajetan.quizapp.entities.Test;
import com.cajetan.quizapp.dao.QuestionDao;
import com.cajetan.quizapp.dao.TestDao;

import jakarta.transaction.Transactional;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;
	
	@Autowired
	TestDao testDao;
	
	@Transactional
	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		 
	}
	
	@Transactional
	public ResponseEntity<String> addQuestion(Question q) {
		questionDao.save(q);
		return new ResponseEntity<>("success",HttpStatus.CREATED);
	}
	
	public void testMethod() {
		testDao.findAll();
	}
	
	public void addTest(Test q) {
		testDao.save(q);
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		
		try {
			return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
		//checking git
	}

}
