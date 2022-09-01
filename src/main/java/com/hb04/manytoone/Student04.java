package com.hb04.manytoone;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Student04 {
/*
@Id annotation makes variable primary key it uniquely identifies each row in a table it must be unique can not contain NULL values.
 */
	@Id

	private int id;

	@Column(name = "student_name",nullable = false, unique = true) //if we want to change default values on column
	private String name;

	private int grade;

	@Column(name = "created_on")
	private LocalDateTime createdOn;

	@Column(name = "updated_on")
	private LocalDateTime updatedOn;

	@ManyToOne
	@JoinColumn(name = "university_id")
	private University university;

	@PrePersist
	public void prePersist(){
		createdOn = LocalDateTime.now();
	}

	@PreUpdate
	public void preUpdate(){
		updatedOn = LocalDateTime.now();
	}


	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student04{" +
				"id=" + id +
				", name='" + name + '\'' +
				", grade=" + grade +
				", createdOn=" + createdOn +
				", updatedOn=" + updatedOn +
				", university=" + university +
				'}';
	}
}