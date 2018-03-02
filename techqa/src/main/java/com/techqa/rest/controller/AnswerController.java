package com.techqa.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techqa.rest.domain.QuestionDto;
import com.techqa.rest.service.IQuestionService;

@Controller
@RequestMapping(value = "/restapi/answer")
public class AnswerController {

	@Autowired
	IQuestionService questionService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<QuestionDto> getAnswerByQuestion(String questionId) {
		List<QuestionDto> questions = questionService.findAllQuestions();
		if (questions != null && questions.size() < 1) {
			questionService.saveQuestions();
			questions = questionService.findAllQuestions();
		}

		return questions;
	}
}
