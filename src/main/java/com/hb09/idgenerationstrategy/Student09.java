package com.hb09.idgenerationstrategy;

import com.hb08.fetchtypes.Book08;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity

public class Student09 extends BaseEntity{
	/*
	 * @Id annotation makes variable primary key
	 * it uniquely identifies each row in a table
	 * it must be unique
	 * can not contain NULL values
	 */
//	@Id
//	@GeneratedValue //AUTO , it implements id by default
//	@GeneratedValue(strategy = GenerationType.IDENTITY) // in db it gives automatically a value, even if we enter new value without id in db it still works.
//	@GeneratedValue(strategy = GenerationType.SEQUENCE) // if we add new value in db without an id, it complains
//	@GeneratedValue(strategy = GenerationType.TABLE) //

//	@GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE) // we select the generator type
//	@SequenceGenerator(name = "sequence" , sequenceName = "student_seq", initialValue = 1000, allocationSize = 50) // select sequence name and define the id value and increased type

//  type  @GeneratedValue(generator = "UUID")
//	@GenericGenerator(name = "UUID", strategy = "uuid2") // it gives 2711af2b-5cdd-46b9-8c86-5e2dd26038f0  as id
//	//8-4-4-4-12=31 characters, 128 bits
//
////	private int id;
//	private String id;

	@Column(name="student_name",length=100, nullable=false, unique = false)
	private String name;

	private int grade;


//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

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
		return "Student09 [id=" + getId() + ", name=" + name + ", grade=" + grade + "]";
	}
}