package com.hb10.hql_criteriaapi;

import com.hb09.idgenerationstrategy.Book09;
import com.hb09.idgenerationstrategy.Student09;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Random;

public class RunnerSave10 {
    public static void main(String[] args) {


        Student09 student2=new Student09();
        student2.setName("James Bond");
        student2.setGrade(11);

        Student09 student3=new Student09();
        student3.setName("Tony Stark");
        student3.setGrade(9);

        Configuration con=new  Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student10.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();

        Random random = new Random();
        for (int i = 1; i <= 50; i++) {
            Student10 student1 = new Student10();
            student1.setName("Name "+i);
            student1.setGrade(random.nextInt(100));
            session.save(student1);
        }



        //it makes data to write into database, makes data permanent
        tx.commit();

        //we have to call session close to release connection
        session.close();
        sf.close();

    }
}
