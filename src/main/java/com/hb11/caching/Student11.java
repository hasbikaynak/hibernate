package com.hb11.caching;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;


@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE,region = "Student11")

public class Student11 {
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
		return "Student11 [id=" + id + ", name=" + name + ", grade=" + mathGrade + "]";
	}
}