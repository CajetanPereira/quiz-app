package com.cajetan.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cajetan.quizapp.entities.Test;

@Repository
public interface TestDao extends JpaRepository<Test, Integer>{
	
}
