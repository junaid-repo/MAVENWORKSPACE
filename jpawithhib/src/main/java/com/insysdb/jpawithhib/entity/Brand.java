package com.insysdb.jpawithhib.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Brand {

	@Id
	@GeneratedValue
	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	protected Brand() {
	}
	
	@OneToMany
    List<Model> models = new ArrayList<>();

	public Brand(String name) {
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
