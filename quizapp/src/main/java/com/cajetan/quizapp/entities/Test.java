package com.cajetan.quizapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
public class Test {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String testcol;
	
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Test(int id, String testcol) {
		super();
		this.id = id;
		this.testcol = testcol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTestcol() {
		return testcol;
	}

	public void setTestcol(String testcol) {
		this.testcol = testcol;
	}

	@Override
	public String toString() {
		return "Test [id=" + id + ", testcol=" + testcol + "]";
	}
	
	

}
