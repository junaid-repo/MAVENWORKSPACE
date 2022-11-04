package com.databasedemo.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.databasedemo.jdbc.entity.Person;

@Repository
public class PersonJdbcDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Person> findAll() {

		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));

	}

	public Person findById(int id) {

		return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));

	}

	public Person findByLocation(String location) {
		return jdbcTemplate.queryForObject("select * from person where location=?", new Object[] { location },
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public Person updateTable(int id, String name, String location) {
		return jdbcTemplate.queryForObject("INSERT INTO PERSON VALUES(?,?,?)", new Object[] { location },
				new BeanPropertyRowMapper<Person>(Person.class));
	}
}
