package com.jpa.hibernate.hibdemo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jpa.hibernate.hibdemo.HibdemoApplication;
import com.jpa.hibernate.hibdemo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HibdemoApplication.class)
class CourseRepositoryTest {

	@Autowired
	CourseRepository repo;

	@Test
	void findById_test() {

		Course course = repo.findById(1001L);

		assertEquals("JDBC", course.getName());

		System.out.println(course);

	}

	@Test
	void deleteById_test() {

		repo.deleteById(1002L);

		// Course course = repo.findById(1003L);

		assertNull(repo.findById(1002L));

		// System.out.println(course);

	}

	@Test
	void addCouse_test() {
		Course cr = new Course("Oracle DB");
		repo.addCourse(cr);

		System.out.println(cr.getName());

		assertEquals("Oracle DB", cr.getName());
	}

	@Test
	void playWithEntityManager() {

		repo.playWithEntityManager();

	}

	@Test
	void playWithEntityManager2() {

		repo.playWithEntityManager2();

	}
}
