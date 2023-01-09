package com.jpa.hibernate.hibdemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;

	private String ratings;

	private String descriptions;
	
	@ManyToOne
	private Course course;
	
	

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	protected Review() {

	}
	

	public Review(String ratings, String descriptions) {
		super();
		this.ratings = ratings;
		this.descriptions = descriptions;
	}

	public Long getId() {
		return id;
	}

	
	public String getRatings() {
		return ratings;
	}

	public void setRatings(String ratings) {
		this.ratings = ratings;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", ratings=" + ratings + ", descriptions=" + descriptions + "]";
	}

}
