package hibernate;

import org.hibernate.Session;

import org.hibernate.SessionFactory;

import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;



public class RunnerSave01 {

	public static void main(String[] args) {

		Student student1 = new Student();
		student1.setId(1001);
		student1.setName("John Coffee");
		student1.setGrade(34);

		Student student2 = new Student();
		student2.setId(1002);
		student2.setName("Tony Stark");
		student2.setGrade(70);

		Student student3 = new Student();
		student3.setId(1003);
		student3.setName("James Heller");
		student3.setGrade(52);



		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();


		session.save(student1);
		session.save(student2);
		session.save(student3);


		//it makes data to write into database, makes data parmanent //UOF -- unit of work
		tx.commit();


		//we have to call session close to release connection
		session.close();

		sf.close();

	}

}