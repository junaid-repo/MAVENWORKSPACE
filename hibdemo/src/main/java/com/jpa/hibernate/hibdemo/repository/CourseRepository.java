package com.jpa.hibernate.hibdemo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.hibernate.hibdemo.entity.Course;
import com.jpa.hibernate.hibdemo.entity.Review;

import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {

	@Autowired
	EntityManager em;

	public Course findById(Long id) {

		Course course = em.find(Course.class, id);
		return course;
	}

	public void deleteById(Long id) {

		Course course = em.find(Course.class, id);

		em.remove(course);
	}

	public Course addCourse(Course courses) {
		Course course = em.merge(courses);

		return course;
	}

	public void playWithEntityManager() {

		// Course cr = new Course("Multithreading in Java");

		// em.persist(cr);
		// cr.setName("Multitheading in Java- Updated");

		Course cr1 = new Course("Rest Web Services");
		em.persist(cr1);
		em.flush();
		em.detach(cr1);
		cr1.setName("Rest API Web Service");

		Course cr2 = new Course("MavenWorkspace");
		em.persist(cr2);
		em.flush();
		em.persist(cr2);
		em.flush();
	}

	public void playWithEntityManager2() {

		// Course cr = new Course("Multithreading in Java");

		// em.persist(cr);
		// cr.setName("Multitheading in Java- Updated");

		Course cr1 = new Course("Rest Web Services");

		// cr1.setName(null);
		em.persist(cr1);

	}

	public void playWithEntityManager3() {

		// Course cr = new Course("Multithreading in Java");

		// em.persist(cr);
		// cr.setName("Multitheading in Java- Updated");

		Course cr1 = new Course("Rest Web Services");

		// cr1.setName(null);
		em.persist(cr1);

		Course cr2 = findById(1001L);
		cr2.setName("The update name");

	}

	public void addHardCodedReviewsForCourses() {

		Course course = findById(1003L);

		Review review1 = new Review("5", "Outstanding course");
		review1.setCourse(course);
		course.addReviews(review1);

		Review review2 = new Review("4", "Good way of teaching");
		review2.setCourse(course);
		course.addReviews(review2);

		em.persist(review1);
		em.persist(review2);

	}

	public void addReviewsForCourses(Long courseId, List<Review> reviews) {

		Course course = findById(courseId);

		for (Review review : reviews) {

			review.setCourse(course);
			course.addReviews(review);
			em.persist(review);
		}

	}
}
