package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "t_student")// If we wouldn`t write table annotation, then we couldn`t change the entity table name

public class Student {
/*
@Id annotation makes variable primary key it uniquely identifies each row in a table it must be unique can not contain NULL values.
 */
	@Id // primary key and column

	private int id;

	@Column(name = "student_name",nullable = false, unique = true) //if we want to change default values on column
	private String name;


	private int grade;


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
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				", grade=" + grade +
				'}';
	}
}