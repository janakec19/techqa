package com.techqa.rest.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.techqa.rest.dao.IQuestionDao;
import com.techqa.rest.domain.QuestionDto;
import com.techqa.rest.entity.Question;
import com.techqa.rest.entity.User;
import com.techqa.rest.service.IQuestionService;

@Component
@Transactional
public class QuestionService implements IQuestionService {

	@Autowired
	IQuestionDao questionDao;

	@Override
	public void saveQuestions() {
		List<Question> questions = new ArrayList<>();
		User user = new User("jana", "123", "I am Jana", new Date());
		questions.add(new Question("Spring security authentication and authorization",
				"I'm looking for a clean way to return customized 404 errorpages in Spring 4 when a requested resource was not found."
						+ " Queries to different domain types should result in different error pages."
						+ "Here some code to show my intention (Meter is a domain class)", 1, "java", user, new Date(),
				new Date()));

		questions.add(new Question(
				"Why am I getting “undefined” while writing the JSON data to a text file in NodeJS?",
				"I was trying this code in NodeJs to write the data received from the server to a text file."
						+ " I tried several times but still getting the 'undefined' in my file.", 2, "javaScript",
				user, new Date(), new Date()));

		questions
				.add(new Question(
						"Getting java.lang.StringIndexOutOfBoundsException while sending mail",
						"I have a checkbox inside a gridview and want to change the color of the same by clicking on it."
								+ "I have used the jquery mentioned above, but it's working only for the first entry of the gridview."
								+ "Any idea what am I doing wrong ?", 2, "java", user, new Date(), new Date()));

		questions.add(new Question("Jquery only working for the first entry of the gridview",
				"I'm looking for a clean way to return customized 404 errorpages in Spring 4 when a requested resource was not found."
						+ " Queries to different domain types should result in different error pages."
						+ "Here some code to show my intention (Meter is a domain class)", 1, "Jquery", user,
				new Date(), new Date()));

		questions.add(new Question("creating custom array from existing array in javascript",
				"need to create custom array", 3, "javaScript", user, new Date(), new Date()));

		questionDao.saveAllQuestions(questions);
	}

	@Override
	public List<QuestionDto> findAllQuestions() {
		List<QuestionDto> questionDtos = new ArrayList<>();
		for (Question question : questionDao.findAllQuestions()) {
			questionDtos.add(QuestionDto.getQuestionDto(question));
		}

		return questionDtos;
	}
}
