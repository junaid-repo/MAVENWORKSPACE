package com.databasedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.databasedemo.jdbc.PersonJdbcDAO;
import com.databasedemo.jdbc.entity.Person;
import com.databasedemo.jdbc.jpa.PersonJpaRepository;

@SpringBootApplication
public class JPADemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JPADemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println(repository.findById(10002));

		System.out.println(repository.insert(new Person(1005, "Amit", "Tata")));
		System.out.println(repository.findAll());
		repository.deleteById(10001);
		// System.out.println(repository.update(1005, "Amit", "Tata"));
		// System.out.println(repository.update(10001, "Tatisilye"));
		/*
		 * System.out.println(dao.deleteById(10001));
		 * 
		 * System.out.println(dao.findById(10002));
		 * System.out.println(dao.findByLocation("Kolkata")); // TODO Auto-generated
		 * method stub
		 * 
		 * System.out.println(dao.insertInTable(1005, "Amit", "Tata"));
		 * System.out.println(dao.updateTable(10001, "Tatisilye"));
		 * System.out.println(dao.findAll());
		 */
	}

}
