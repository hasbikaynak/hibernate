package com.hb03.onetoone;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {
    public static void main(String[] args) {
        Diary diary1 = new Diary();
        Diary diary2 = new Diary();
        Diary diary3 = new Diary();
        Diary diary4 = new Diary();

        Student03 student1 = new Student03();
        student1.setId(1001);
        student1.setName("John Coffee");
        student1.setGrade(11);
      student1.setDiary(diary1);


        Student03 student2 = new Student03();
        student2.setId(1002);
        student2.setName("Tony Stark");
        student2.setGrade(67);

        Student03 student3 = new Student03();
        student3.setId(1003);
        student3.setName("James Bond");
        student3.setGrade(12);
        student3.setDiary(diary3);

        Student03 student4 = new Student03();
        student4.setId(1004);
        student4.setName("James Heller");
        student4.setGrade(12);
        student4.setDiary(diary4);


        diary1.setId(101);
        diary1.setName("John`s Diary");
        diary1.setStudent(student1);

        diary3.setId(103);
        diary3.setName("Tonny`s diary");
        diary3.setStudent(student3);

        diary4.setId(104);
        diary4.setName("JamesHeller`s diary");
        diary4.setStudent(student4);




        Configuration con=new  Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();
//        session.save(student1);
//        session.save(student2);
//        session.save(student3);
        session.save(student4);

//        session.save(diary1);
//        session.save(diary2);
//        session.save(diary3);
        session.save(diary4);




        //it makes data to write into database, makes data permanent
        tx.commit();

        //we have to call session close to release connection
        session.close();
        sf.close();
    }


}
