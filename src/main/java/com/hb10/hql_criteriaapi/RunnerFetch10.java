package com.hb10.hql_criteriaapi;

import com.hb09.idgenerationstrategy.Book09;
import com.hb09.idgenerationstrategy.Student09;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;


public class RunnerFetch10 {
    public static void main(String[] args) {

        //CRUD
        //Create - session.save
        //Read - session.get,hql,sql
        //Update - update query, session.update
        //Delete - session.delete and hql,sql

        //

        Configuration con=new  Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student10.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();

//        String hqlQuery = "from Student10 where mathGrade > 50";
//        List<Student10>  resultList = session.createQuery(hqlQuery,Student10.class).getResultList();
//        resultList.forEach(System.out::println);

        //How to use parameter in HQL
//        int studentId = 10;
//        Query<Student10> query  =  session.createQuery("from Student10 s where s.id = :id",Student10.class);
//         query.setParameter("id",studentId);
//         List<Student10> resultList2 = query.getResultList();
//         resultList2.forEach(System.out::println);



//        String hqlQuery2 = "SELECT sum(mathGrade) FROM Student10 where mathGrade > 90";
//        Long  resultList = (Long)session.createQuery(hqlQuery2).uniqueResult();
//        System.out.println("Total math grade: "+resultList);

//        int mathGrade = 90;
//        String hqlQuery = "Select avg(mathGrade) from Student10 where mathGrade > :mathGrade";
//        Query query = session.createQuery(hqlQuery);
//        query.setParameter("mathGrade",mathGrade);
//        Double avgMathGrade = (Double) query.uniqueResult();
//        System.out.println("Avg math grade: "+avgMathGrade);


        //UPDATE Hibernate
//        Student10 student1 =  session.get(Student10.class,1);
//        student1.setName("Updated "+ student1.getName());
//        session.update(student1);

        //UPDATE HQL query
//        String hqlQuery = "Update Student10 s set s.name = 'Updated with HQL' where s.id = 11";
//        int numOfRecord = session.createQuery(hqlQuery).executeUpdate();
//        System.out.println("Effected row count: "+numOfRecord);

//        String hqlQuery = "from Student10 s where s.mathGrade < 50";
//        List<Student10> resultList = session.createQuery(hqlQuery,Student10.class).getResultList();
//        for (Student10 student: resultList) {
//            student.setGrade(50);
//            session.update(student);
//        }

//        CriteriaApi
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Student10> criteriaQuery = cb.createQuery(Student10.class);
//        Root<Student10> root =  criteriaQuery.from(Student10.class);

//        criteriaQuery.select(root);
//        criteriaQuery.select(root).where(cb.equal(root.get("name"),"Name 10")); //IMPORTANT ***********
//        criteriaQuery.select(root).where(cb.greaterThan(root.get("mathGrade"),50));
//        criteriaQuery.select(root).where(cb.lessThan(root.get("mathGrade"),90));

        //Predicate
//        Predicate predicateForName = cb.equal(root.get("name"),"Name 10");
////        Predicate predicateForMathGradeGt80 = cb.greaterThan(root.get("mathGrade"), 80);
////        Predicate predicateStd = cb.or(predicateForName,predicateForMathGradeGt80);
////
////        criteriaQuery.where(predicateStd);
////
////        Query<Student10> query = session.createQuery(criteriaQuery);
////        List<Student10> resulList = query.getResultList();
////
////        resulList.forEach(System.out::println);

        //Aggregate Function sum
        CriteriaBuilder cb =  session.getCriteriaBuilder();
        CriteriaQuery<Integer> criteriaQuery = cb.createQuery(Integer.class);
        Root<Student10> root = criteriaQuery.from(Student10.class);

        criteriaQuery.select(cb.sum(root.get("mathGrade")));

        TypedQuery<Integer> query = session.createQuery(criteriaQuery);

        Integer sum = query.getSingleResult();

        System.out.println("Total math grade: "+ sum);


        //it makes data to write into database, makes data permanent
        tx.commit();

        //we have to call session close to release connection
        session.close();
        sf.close();
    }
}
