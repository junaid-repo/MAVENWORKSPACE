package com.databasedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.databasedemo.jdbc.PersonJdbcDAO;

//@SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJdbcDAO dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// logger.info("{}",dao.findAll());
		// System.out.println(dao.deleteById(10001));

		 System.out.println(dao.findById(10002));
		 System.out.println(dao.findByLocation("Kolkata"));
		// TODO Auto-generated method stub

		//System.out.println(dao.insertInTable(1005, "Amit", "Tata"));
		//System.out.println(dao.updateTable(10001, "Tatisilye"));
		//System.out.println(dao.findAll());
	}

}
