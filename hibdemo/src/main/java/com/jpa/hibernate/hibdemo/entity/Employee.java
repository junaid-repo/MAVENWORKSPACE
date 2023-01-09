package com.jpa.hibernate.hibdemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Employee {

	@Column(nullable=false)
	private String name ="";
	
	@Id
	@GeneratedValue
	private int id;
	public Employee(String name) {
		this.name=name;
	}

	protected Employee() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + "]";
	}
	

	
}
