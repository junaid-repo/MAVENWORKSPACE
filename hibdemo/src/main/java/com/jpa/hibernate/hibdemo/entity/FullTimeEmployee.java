package com.jpa.hibernate.hibdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class FullTimeEmployee extends Employee {

	private float salary = 0f;
	
	protected FullTimeEmployee() {
		
	}

	public FullTimeEmployee(String name, float salary) {
		super(name);
		this.salary = salary;
	}

}
