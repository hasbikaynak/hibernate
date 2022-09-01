package com.hb08.fetchtypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.awt.print.Book;
import java.util.List;

public class RunnerFetch08 {
    public static void main(String[] args) {
      Student08 student  =   getStudent();

      //it creates LazyInitException because agter session closed we cant access related entities with the lazy fetch type
//        System.out.println(student.getBookList().size());

      //to get booklist we used another method
        List<Book08> bookList  =getBooksById(student.getId());
        System.out.println("Book List size: " + bookList.size());
        for (Book08 book: bookList) {
            System.out.println(book.getBookName());
        }
    }

    private static List<Book08> getBooksById(int id){

        Configuration con=new  Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student08.class).addAnnotatedClass(Book08.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();


        List<Book08> bookList = session.createQuery("From Book08 b where b.student = " + id,Book08.class).getResultList();



        tx.commit();

        session.close();
        sf.close();
        return bookList;
    }

    private static Student08 getStudent(){

        Configuration con=new  Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student08.class).addAnnotatedClass(Book08.class);

        SessionFactory sf=con.buildSessionFactory();
        Session session= sf.openSession();

        Transaction tx= session.beginTransaction();


        Student08 student= session.get(Student08.class, 1001);
//        session.delete(student);
        System.out.println(student);

//        Book05 university= session.get(Book05.class, 101);
//
//        System.out.println(university);
        //
        //it makes data to write into database, makes data permanent
        tx.commit();

//      if your fetch type is lazy when you want to access a related object you get  LazyInitializationException
        //but eager uses memory even we closed the session we can access to the related objects.
//        System.out.println(student.getBookList());


        //we have to call session close to release connection
        session.close();
        sf.close();

        return student;
    }
}
