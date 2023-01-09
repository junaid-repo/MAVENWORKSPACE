package com.jpa.hibernate.hibdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table
public class PartTimeEmployee extends Employee{
	
	private float hourlyWage=0f;
	
	protected PartTimeEmployee() {
		
	}

	public PartTimeEmployee(String name, float hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}
	
	

}
