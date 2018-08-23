package com.google.swarm.microservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "registration_data")
public class Registration {
	@Id
	@Column(name = "id")
	private String registrationId;

	@Column(name = "student_id")
	private String studentId;

	@Column(name = "course_name")
	private String courseId;
	public Registration() {
	}

	@Transient
	private String cost;
	
	public Registration(String registrationId, String studentId, String courseId) {
		this.registrationId= registrationId;
		this.studentId= studentId;
		this.courseId = courseId;
		this.cost=String.valueOf("$0");
		
	
	}

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	public String getCost() {
		return String.format("$%s", (int) ((Math.random() * ((2000 - 1000) + 1)) + 1000));
				
				
	}

	public void setCost(String cost) {
		this.cost=cost;
	}
	@Override
	public String toString() {
		return "Registration [registrationId=" + registrationId + ", studentId=" + studentId + ", courseId=" + courseId
				+ "]";
	}

}
