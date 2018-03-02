package com.techqa.rest.dao;

import java.util.List;

import com.techqa.rest.entity.Question;

public interface IAnswerDao {

	public List<Question> findAllQuestions();

	void saveAllQuestions(List<Question> questions);

}
