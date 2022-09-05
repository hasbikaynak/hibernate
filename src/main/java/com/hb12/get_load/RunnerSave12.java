package com.hb12.get_load;

import com.hb11.caching.Student11;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave12 {
    public static void main(String[] args) {


        Student12 student1=new Student12();
        student1.setName("James Bond");
        student1.setGrade(11);

        Student12 student2=new Student12();
        student2.setName("Tonny Stark");
        student2.setGrade(12);


        Configuration con=new  Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student12.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();

//       session.save(student1);
       session.save(student2);




        //it makes data to write into database, makes data permanent
        tx.commit();

        //we have to call session close to release connection
        session.close();
        sf.close();

    }
}
