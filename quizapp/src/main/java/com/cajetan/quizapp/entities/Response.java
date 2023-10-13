package com.cajetan.quizapp.entities;

public class Response {
	
	private Integer questionid;
	private String response;
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Response(Integer questionid, String response) {
		super();
		this.questionid = questionid;
		this.response = response;
	}
	public Integer getQuestionid() {
		return questionid;
	}
	public void setQuestionid(Integer questionid) {
		this.questionid = questionid;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "Response [questionid=" + questionid + ", response=" + response + "]";
	}
	
	

}
