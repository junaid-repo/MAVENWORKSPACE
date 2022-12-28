package com.jpa.hibernate.hibdemo.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
public class Passport {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String passportnumber;

	protected Passport() {

	}
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="passport")
	private Student student;
	
	

	public String getPassportnumber() {
		return passportnumber;
	}

	public void setPassportnumber(String passportnumber) {
		this.passportnumber = passportnumber;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Passport(String passportnumber) {
		super();
		this.passportnumber = passportnumber;
	}

	public String getName() {
		return passportnumber;
	}

	public void setName(String passportnumber) {
		this.passportnumber = passportnumber;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Passport [passportnumber=" + passportnumber + "]";
	}

}
