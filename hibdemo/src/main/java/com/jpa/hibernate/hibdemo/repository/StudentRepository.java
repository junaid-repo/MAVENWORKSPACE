package com.jpa.hibernate.hibdemo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.hibernate.hibdemo.entity.Course;
import com.jpa.hibernate.hibdemo.entity.Passport;
import com.jpa.hibernate.hibdemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class StudentRepository {

	@Autowired
	EntityManager em;

	public Student findById(Long id) {

		Student student = em.find(Student.class, id);
		return student;
	}

	public void deleteById(Long id) {

		Student student = em.find(Student.class, id);

		em.remove(student);
	}

	public Student addStudent(Student students) {
		Student student = em.merge(students);

		return student;
	}

	public void playWithEntityManager() {

		// Student cr = new Student("Multithreading in Java");

		// em.persist(cr);
		// cr.setName("Multitheading in Java- Updated");

		Student cr1 = new Student("Rest Web Services");
		em.persist(cr1);
		em.flush();
		em.detach(cr1);
		cr1.setName("Rest API Web Service");

		Student cr2 = new Student("MavenWorkspace");
		em.persist(cr2);
		em.flush();
		em.persist(cr2);
		em.flush();
	}

	public void saveStudentWithPassport() {
		Passport passport = new Passport("BE8788JS");

		em.persist(passport);

		Student student = new Student("Nemat");

		student.setPassport(passport);

		em.persist(student);

	}

	public void insertStudentAndCourse() {

		Student student = new Student("Jack");
		Course course = new Course("Angular JS");

		em.persist(course);
		em.persist(student);

		student.addCourses(course);
		course.addStudent(student);

		em.persist(student);

	}

	public void jpql_similar_passportNumber() {
		TypedQuery qry = em.createQuery("SELECT * FROM PASSPORT p where p.passportnumber =  '%123%'",
				Passport.class);
		List<Passport> crs = qry.getResultList();
		System.out.println("The output of the test jpql_similar_passportNumber is--> " + crs);

	}
}
