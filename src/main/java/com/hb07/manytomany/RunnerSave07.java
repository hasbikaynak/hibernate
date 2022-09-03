package com.hb07.manytomany;

import com.hb06.bi_onetomany.Book06;
import com.hb06.bi_onetomany.Student06;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class RunnerSave07 {
    public static void main(String[] args) {
        Student07 student1=new Student07();
        student1.setId(1001);
        student1.setName("John Coffee");
        student1.setGrade(10);

        Student07 student2=new Student07();
        student2.setId(1002);
        student2.setName("James Bond");
        student2.setGrade(11);

        Student07 student3=new Student07();
        student3.setId(1003);
        student3.setName("Tony Stark");
        student3.setGrade(9);


        Book07 book1=new Book07();
        book1.setId(101);
        book1.setBookName("Art Book");
        book1.setType(BookType.ART);

        Book07 book2=new Book07();
        book2.setId(102);
        book2.setBookName("Calculus 1");
        book2.setType(BookType.MATH);

        List<Book07> bookList1=new ArrayList<>();
        bookList1.add(book1);
        bookList1.add(book2);
        student1.setBookList(bookList1);


        List<Book07> bookList2=new ArrayList<>();
        bookList2.add(book1);
        student2.setBookList(bookList2);


        List<Book07> bookList3=new ArrayList<>();
        bookList3.add(book2);
        student3.setBookList(bookList3);

        List<Student07> studentList =new ArrayList<>();
        studentList.add(student1);
        book1.setStudents(studentList);





        Configuration con=new  Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();


        session.save(student1);
        session.save(student2);
        session.save(student3);

        session.save(book1);
        session.save(book2);

        //
        //it makes data to write into database, makes data permanent
        tx.commit();

        //we have to call session close to release connection
        session.close();
        sf.close();

    }
}
