package com.hb03.onetoone;

import javax.persistence.*;

@Entity
public class Diary {

    @Id
    private int id;

    private String name;

    @OneToOne
    @JoinColumn(name = "my_student_id") //Gives specific name to the column for one-to-one relation
    private Student03 student;


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

    public Student03 getStudent() {
        return student;
    }

    public void setStudent(Student03 student) {
        this.student = student;
    }

//    @Override
//    public String toString() {
//        return "Diary{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", student=" + student +
//                '}';
//    }


    @Override
    public String toString() {
        return "Diary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
