package com.hb14.concurancy_locktype;

import javax.persistence.*;


@Entity

public class Student14 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="student_name",length=100, nullable=false, unique = false)
	private String name;

	private int mathGrade;

//	@Version //it prevents data complication. If you want to update some value at the same time, you can use this.
//	private  Long version;


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
		return "Student13 [id=" + id + ", name=" + name + ", grade=" + mathGrade + "]";
	}
}