package com.qtechlabs.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class CourseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long courseId;

	private String courseName;

	private String courseDescription;

	private int duration;

	private long fees;

	private String instructor;

	public CourseEntity() {

	}

	public CourseEntity(Long courseId, String courseName, String courseDescription, int duration, long fees,
			String instructor) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.duration = duration;
		this.fees = fees;
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "CourseEntity [courseId=" + courseId + ", courseName=" + courseName + ", courseDescription="
				+ courseDescription + ", duration=" + duration + ", fees=" + fees + ", instructor=" + instructor + "]";
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public long getFees() {
		return fees;
	}

	public void setFees(long fees) {
		this.fees = fees;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	

}
