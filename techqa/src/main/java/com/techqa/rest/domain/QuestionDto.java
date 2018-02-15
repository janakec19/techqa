package com.techqa.rest.domain;

import java.text.SimpleDateFormat;

import com.techqa.rest.entity.Question;

public class QuestionDto {

	static SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, yyyy");

	private int id;

	private String title;

	private String content;

	private int views;

	private String category;

	private String userName;

	private String creationDate;

	private String lastUpdateDate;

	private int answerCount;

	public static QuestionDto getQuestionDto(Question question) {
		QuestionDto questionDto = new QuestionDto();
		questionDto.setId(question.getId());
		questionDto.setCategory(question.getCategory());
		questionDto.setTitle(question.getTitle());
		questionDto.setContent(question.getContent());
		questionDto.setViews(question.getViews());
		questionDto.setUserName(question.getUser().getUsername());
		questionDto.setCreationDate(formatter.format(question.getCreationDate()));
		questionDto.setLastUpdateDate(formatter.format(question.getLastUpdateDate()));
		return questionDto;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public int getAnswerCount() {
		return answerCount;
	}

	public void setAnswerCount(int answerCount) {
		this.answerCount = answerCount;
	}
}
