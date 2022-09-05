package com.hb13.entity_lif_cycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave13 {
    public static void main(String[] args) {


        Student13 student1=new Student13();
        student1.setName("James Bond");
        student1.setGrade(11);

//        Student13 student2=new Student13();
//        student2.setName("Tonny Stark");
//        student2.setGrade(12);


        Configuration con=new  Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();

       session.save(student1);
//       session.save(student2);




        //it makes data to write into database, makes data permanent
        tx.commit();

        //we have to call session close to release connection
        session.close();
        sf.close();

    }
}
