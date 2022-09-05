package com.hb11.caching;

import com.hb09.idgenerationstrategy.Student09;
import com.hb10.hql_criteriaapi.Student10;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class RunnerSave11 {
    public static void main(String[] args) {


        Student11 student1=new Student11();
        student1.setName("James Bond");
        student1.setGrade(11);

        Student11 student2=new Student11();
        student2.setName("Tony Stark");
        student2.setGrade(9);

        Student11 student3=new Student11();
        student3.setName("James Heller");
        student3.setGrade(12);

        Configuration con=new  Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student11.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();

       session.save(student1);
       session.save(student2);
       session.save(student3);



        //it makes data to write into database, makes data permanent
        tx.commit();

        //we have to call session close to release connection
        session.close();
        sf.close();

    }
}
