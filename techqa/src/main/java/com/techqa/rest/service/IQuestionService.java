package com.techqa.rest.service;

import java.util.List;

import com.techqa.rest.domain.QuestionDto;

public interface IQuestionService {

	void saveQuestions();

	List<QuestionDto> findAllQuestions();
}
