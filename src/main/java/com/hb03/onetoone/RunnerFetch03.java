package com.hb03.onetoone;

import hibernate.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

public class RunnerFetch03 {
    public static void main(String[] args) {

        Configuration con=new  Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);
        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();

//        Diary diary = session.get(Diary.class,101);
//        System.out.println(diary.getStudent());
//
//        Student03 student = session.get(Student03.class,1001);
//        System.out.println(student.getDiary());

//        String hqlQuery1 = "SELECT s.name,d.name FROM Student03 s INNER JOIN FETCH Diary d on s.id=d.student";
//        List<Object[]> resultList1 = session.createQuery(hqlQuery1).getResultList();
//
//        for (Object[] objects : resultList1
//             ) {
//            System.out.println(Arrays.toString(objects));
//        }

//        String hqlQuery2 = "FROM Student03 s INNER JOIN FETCH s.diary";
//        List<Student03> resultList = session.createQuery(hqlQuery2).getResultList();
//
//        for (Student03 student: resultList
//             ) {
//            System.out.println(student);
//        }

//        String hqlQuery3 = "FROM Diary d INNER JOIN FETCH d.student";
//        List<Diary> resultList = session.createQuery(hqlQuery3).getResultList();
//
//        for (Diary diary: resultList
//        ) {
//            System.out.println(diary);
//        }

        String hqlQuery4 = "SELECT new com.hb03.onetoone.CustomResult(s.name,d.name) FROM Student03 s inner join fetch Diary d on s.id=d.student";
         List<CustomResult> results = session.createQuery(hqlQuery4).list();

        for (CustomResult result: results
             ) {
            System.out.println(result);
        }

//        Query query =  session.createQuery("From Student03");
//        List<Student03> resultList = query.getResultList();
//
//        for (Student03 student03: resultList
//             ) {
//            System.out.println(student03);
//        }




        //it makes data to write into database, makes data permanent
        tx.commit();

        //we have to call session close to release connection
        session.close();
        sf.close();
    }
}
