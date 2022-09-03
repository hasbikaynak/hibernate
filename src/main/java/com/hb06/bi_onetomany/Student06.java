package com.hb06.bi_onetomany;

import com.hb05.onetomany.Book05;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student06 {

        /*
        @Id annotation makes variable primary key it uniquely identifies each row in a table it must be unique can not contain NULL values.
         */
        @Id

        private int id;

        @Column(name = "student_name", nullable = false, unique = true) //if we want to change default values on column
        private String name;


        private int grade;



        @OneToMany(mappedBy = "student",orphanRemoval = true) //by using that we can delete without any problem, otherwise it will complain that first you have to
        //all relations
        private List<Book06> bookList = new ArrayList<>();

        @Override
        public String toString() {
            return "Student06{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", grade=" + grade +
                    ", bookList=" + bookList +
                    '}';
        }

    public List<Book06> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book06> bookList) {
        this.bookList = bookList;
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

    }


