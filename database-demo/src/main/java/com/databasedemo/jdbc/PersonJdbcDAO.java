package com.databasedemo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.databasedemo.jdbc.entity.Person;

@Repository
public class PersonJdbcDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setLocation(rs.getString("location"));
			person.setName(rs.getString("name"));
			return person;
		}

	}

	public List<Person> findAll() {

		return jdbcTemplate.query("select * from person", new PersonRowMapper());

	}

	public Person findById(int id) {

		return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Person>(Person.class));

	}

	public Person findByLocation(String location) {
		return jdbcTemplate.queryForObject("select * from person where location=?", new Object[] { location },
				new BeanPropertyRowMapper<Person>(Person.class));
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("DELETE  FROM PERSON WHERE ID=? ", new Object[] { id });
	}

	public int insertInTable(int id, String name, String location) {
		return jdbcTemplate.update("insert into person values (?,?,?) ", new Object[] { id, name, location });
	}

	public int updateTable(int id, String location) {
		return jdbcTemplate.update("update person " + " set location = ?" + " where id=? ",
				new Object[] { location, id });
	}
}
