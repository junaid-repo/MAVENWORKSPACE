package com.jpa.hibernate.hibdemo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@OneToOne(fetch = FetchType.LAZY)
	Passport passport;

	public Student(String name) {
		super();
		this.name = name;
	}

	protected Student() {

	}

	@ManyToMany
	@JoinTable(name = "STUDENT_COURSE", joinColumns = @JoinColumn(name = "STUDENT_ID"), inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
	List<Course> courses = new ArrayList<>();

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourses(Course courses) {
		this.courses.add(courses);
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}

}
