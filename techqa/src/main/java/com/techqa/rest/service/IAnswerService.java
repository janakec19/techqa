package com.techqa.rest.service;

import java.util.List;

import com.techqa.rest.domain.QuestionDto;

public interface IAnswerService {

	void saveQuestions();

	List<QuestionDto> findAllQuestions();
}
