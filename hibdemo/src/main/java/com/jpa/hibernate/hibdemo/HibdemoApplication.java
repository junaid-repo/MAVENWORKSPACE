package com.jpa.hibernate.hibdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.hibernate.hibdemo.entity.Employee;
import com.jpa.hibernate.hibdemo.entity.FullTimeEmployee;
import com.jpa.hibernate.hibdemo.entity.PartTimeEmployee;
import com.jpa.hibernate.hibdemo.repository.CourseRepository;
import com.jpa.hibernate.hibdemo.repository.EmployeeRepository;
import com.jpa.hibernate.hibdemo.repository.StudentRepository;

@SpringBootApplication
public class HibdemoApplication implements CommandLineRunner {

	@Autowired
	CourseRepository repo;

	@Autowired
	StudentRepository srepo;

	@Autowired
	EmployeeRepository erepo;

	public static void main(String[] args) {
		SpringApplication.run(HibdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Course course = repo.findById(1001L);
		// System.out.println(course);

		// repo.deleteById(1003L);

		// Course cr = new Course("Oracle SQL");

		// Course course1 = repo.addCourse(cr);

		// repo.playWithEntityManager();
		// repo.playWithEntityManager3();

		// srepo.saveStudentWithPassport();
		/*
		 * List<Review> reviews = new ArrayList<>();
		 * 
		 * reviews.add(new Review("4", "Awesome, but can be better")); reviews.add(new
		 * Review("3", "Average, had experienced better"));
		 * 
		 * repo.addReviewsForCourses(1004L, reviews);
		 * repo.addHardCodedReviewsForCourses(); srepo.insertStudentAndCourse();
		 */

		erepo.addEmployee(new FullTimeEmployee("Junaid", 40000f));
		erepo.addEmployee(new PartTimeEmployee("Raja", 1000f));

		List<Employee> eList = new ArrayList<>();

		eList = erepo.getAllEmployee();
		System.out.println("The list of all Employees--->" + eList);
		
		srepo.jpql_similar_passportNumber();

	}

}
