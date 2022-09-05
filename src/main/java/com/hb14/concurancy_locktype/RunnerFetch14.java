package com.hb14.concurancy_locktype;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class RunnerFetch14 {
    public static void main(String[] args) {
        Configuration con=new  Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student14.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();

        session.get(Student14.class, 1, LockMode.PESSIMISTIC_WRITE);


        //This code about the optimistic lock.
//        SessionFactory sf1=con.buildSessionFactory();
//        Session session1= sf1.openSession();
//
//        Transaction tx1= session1.beginTransaction();
//
//        Student14 student1 = session.get(Student14.class,1);
//
//        Student14 student2 = session1.get(Student14.class,1);
//
//        student1.setName("session 1 student");
//        student2.setName("session 2 student");
//
//
//        tx1.commit();
//        session1.close();
//        sf1.close();

        tx.commit();
        session.close();
        sf.close();
    }
}
