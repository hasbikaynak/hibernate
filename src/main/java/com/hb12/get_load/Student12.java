package com.hb12.get_load;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;


@Entity

public class Student12 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="student_name",length=100, nullable=false, unique = false)
	private String name;

	private int mathGrade;


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
		return mathGrade;
	}

	public void setGrade(int grade) {
		this.mathGrade = grade;
	}

	@Override
	public String toString() {
		return "Student12 [id=" + id + ", name=" + name + ", grade=" + mathGrade + "]";
	}
}