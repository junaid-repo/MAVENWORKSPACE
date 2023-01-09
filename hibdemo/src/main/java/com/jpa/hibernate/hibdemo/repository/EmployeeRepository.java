package com.jpa.hibernate.hibdemo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.hibernate.hibdemo.entity.Employee;

import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class EmployeeRepository {

	@Autowired
	EntityManager em;

	public void addEmployee(Employee employee) {
		em.persist(employee);
	}

	public List<Employee> getAllEmployee() {

		return em.createQuery("select e from Employee e", Employee.class).getResultList();
	}

}
