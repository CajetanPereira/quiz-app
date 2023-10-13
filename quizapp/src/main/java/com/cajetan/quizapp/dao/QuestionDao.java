package com.cajetan.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cajetan.quizapp.entities.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

	List<Question>findByCategory(String category);

	@Query(value="select * from question q where q.category=:category order by RANDOM() limit :numQ", nativeQuery = true)
	List<Question> findRandomQuestionsByCategoryWithLimit(String category, int numQ);

}
