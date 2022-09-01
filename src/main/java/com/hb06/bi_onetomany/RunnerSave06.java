package com.hb06.bi_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave06 {
    public static void main(String[] args) {

        Student06 student1 = new Student06();
        student1.setId(1001);
        student1.setName("John Coffee");
        student1.setGrade(34);


        Student06 student3 = new Student06();
        student3.setId(1003);
        student3.setName("James Heller");
        student3.setGrade(23);



        Student06 student2 = new Student06();
        student2.setId(1002);
        student2.setName("Tony Stark");
        student2.setGrade(70);

        Book06 book1 = new Book06();
        book1.setId(101);
        book1.setBookName("John`s Book");

        Book06 book2 = new Book06();
        book2.setId(102);
        book2.setBookName("John`s Math Book");

        Book06 book3 = new Book06();
        book3.setId(103);
        book3.setBookName("Jame`s Java Book");


        book1.setStudent(student1);
        book2.setStudent(student1);

        book3.setStudent(student2);





        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student06.class).addAnnotatedClass(Book06.class);

        SessionFactory sf = con.buildSessionFactory();

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();


        session.save(book1);
        session.save(book2);
        session.save(book3);

        session.save(student1);
        session.save(student2);
        session.save(student3);



        //it makes data to write into database, makes data parmanent //UOF -- unit of work
        tx.commit();


        //we have to call session close to release connection
        session.close();

        sf.close();


    }
}
