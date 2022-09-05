package com.hb13.entity_lif_cycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class RunnerFetch13 {
    public static void main(String[] args) {
        Configuration con=new  Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student13.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();



        System.out.println("Starts to execute get method...");
        Student13 student1 =session.get(Student13.class,1);
        System.out.println("Finishes the execute get method...");
        System.out.println("Student Id: "+student1.getId());
        System.out.println("Student Get Name detail: "+student1.getName());


        System.out.println("Starts to execute load method...");
        Student13 student2 =session.load(Student13.class,2);
        System.out.println("Finishes the execute load method...");
        System.out.println("Student Id: "+student2.getId());
        System.out.println("Student Load Name detail: "+student2.getName());

        

        tx.commit();
        session.close();
        sf.close();
    }
}
