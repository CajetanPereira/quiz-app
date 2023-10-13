package com.cajetan.quizapp.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Quiz {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String title;
	
	@ManyToMany 
	List<Question> questions;

	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Quiz(Integer id, String title, List<Question> questions) {
		super();
		this.id = id;
		this.title = title;
		this.questions = questions;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Quiz [id=" + id + ", title=" + title + ", questions=" + questions + "]";
	}
	
	

}
