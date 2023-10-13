package com.cajetan.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cajetan.quizapp.dao.QuestionDao;
import com.cajetan.quizapp.dao.QuizDao;
import com.cajetan.quizapp.entities.Question;
import com.cajetan.quizapp.entities.QuestionWrapper;
import com.cajetan.quizapp.entities.Quiz;
import com.cajetan.quizapp.entities.Response;

@Service
public class QuizService {
	
	@Autowired
	QuestionDao questionDao;
	
	@Autowired
	QuizDao quizDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String quizTitle) {
		
		List<Question> questions= questionDao.findRandomQuestionsByCategoryWithLimit(category,numQ); 
		Quiz q=new Quiz();
		q.setTitle(quizTitle);
		q.setQuestions(questions);
		quizDao.save(q);
		return null;
	}

	public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {
		Optional<Quiz> q=quizDao.findById(id);
		List<Question> questionsFromDB= q.get().getQuestions();
		List<QuestionWrapper> questionsforUser= new ArrayList<>();
		for(Question qq:questionsFromDB) {
			QuestionWrapper qw=new QuestionWrapper(qq.getId(),qq.getQuestionTitle(),qq.getOption1(),qq.getOption2(),qq.getOption3(),qq.getOption4());
			questionsforUser.add(qw);
		}
		
		return new ResponseEntity<>(questionsforUser,HttpStatus.OK) ;
	}

	public ResponseEntity<Integer> calculateResult(Integer quizId,List<Response> responses) {
		Optional<Quiz> q=quizDao.findById(quizId);
		List<Question> questionsFromDB= q.get().getQuestions();
		int rightAnsCount=0;
		int i=0;
		for(Response resp:responses) {
			if(resp.getResponse().equals(questionsFromDB.get(i).getRightAnswer()))
				rightAnsCount++;
			i++;
		}
		return new ResponseEntity<>(rightAnsCount,HttpStatus.OK);
	}

}
