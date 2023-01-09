package com.insysdb.jpawithhib.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Model {

	@Id
	@GeneratedValue
	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	protected Model() {
	}

	
	@ManyToOne
	Brand brand;
	
	public Model(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}

}
