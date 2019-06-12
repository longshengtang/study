package com.flysky.study.dbunit.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.flysky.study.dbunit.entity.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonService {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Person> find(String name) {
		Query query = entityManager.createNamedQuery("Person.find");
		query.setParameter("name", "%"+name+"%");
		return query.getResultList();
	}

	public static void main(String[] args) {

	}
}
