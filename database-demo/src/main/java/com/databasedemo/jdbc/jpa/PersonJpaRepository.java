package com.databasedemo.jdbc.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.databasedemo.jdbc.entity.Person;

@Transactional
@Repository
public class PersonJpaRepository {

	@PersistenceContext
	EntityManager entityManager;

	public Person findById(int id) {
		Person person = new Person();

		return entityManager.find(Person.class, id);
	}

	public Person insert(Person person) {

		return entityManager.merge(person);
	}

	public void deleteById(int id) {

		Person person = findById(id);

		entityManager.remove(person);
	}

	public List<Person> findAll() {

		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_person", Person.class);

		return namedQuery.getResultList();

	}

}
