package com.jpa.hibernate.hibdemo.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jpa.hibernate.hibdemo.HibdemoApplication;
import com.jpa.hibernate.hibdemo.entity.Passport;
import com.jpa.hibernate.hibdemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibdemoApplication.class)
class StudenRepositoryTest {

	@Autowired
	StudentRepository repo;

	@Autowired
	EntityManager em;

	@Test
	@Transactional
	void retrieveStudentAndPassportDetails() {

		// Student student = repo.findById(2001L);

		Student student = em.find(Student.class, 2001L);

		System.out.println(student);
		System.out.println(student.getPassport());

	}

	@Test
	@Transactional
	public void retrievePassportAndAssociatedStudent() {

		// Student student = repo.findById(2001L);

		Passport passport = em.find(Passport.class, 3003L);

		System.out.println("Passport Details-->" + passport);
		System.out.println("Student Details from Passport-->" + passport.getStudent());

	}

}
