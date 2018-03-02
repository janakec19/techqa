package com.techqa.rest.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.techqa.rest.dao.IQuestionDao;
import com.techqa.rest.entity.Question;

@Repository
public class AnswerDao implements IQuestionDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Question> findAllQuestions() {
		CriteriaQuery<Question> criteriaQuery = em.getCriteriaBuilder().createQuery(Question.class);
		@SuppressWarnings("unused")
		Root<Question> root = criteriaQuery.from(Question.class);
		return em.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public void saveAllQuestions(List<Question> questions) {
		for (Question question : questions) {
			em.persist(question);
		}
	}

}
