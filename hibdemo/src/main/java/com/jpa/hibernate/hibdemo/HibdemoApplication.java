package com.jpa.hibernate.hibdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jpa.hibernate.hibdemo.entity.Course;
import com.jpa.hibernate.hibdemo.repository.CourseRepository;
import com.jpa.hibernate.hibdemo.repository.StudentRepository;

@SpringBootApplication
public class HibdemoApplication implements CommandLineRunner {

	@Autowired
	CourseRepository repo;

	@Autowired
	StudentRepository srepo;

	public static void main(String[] args) {
		SpringApplication.run(HibdemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = repo.findById(1001L);
		System.out.println(course);

		repo.deleteById(1003L);

		Course cr = new Course("Oracle SQL");

		Course course1 = repo.addCourse(cr);

		repo.playWithEntityManager();
		repo.playWithEntityManager3();

		srepo.saveStudentWithPassport();
	}

}
