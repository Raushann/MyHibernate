package com.RaushanHibernate.CRUD.Operation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudent {
	public static void main(String[] args) {
		//create session factory
		SessionFactory factory= new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		// create Session
		Session session=factory.getCurrentSession();
		try {
			
			//start a transaction
			session.beginTransaction();
			
			// Query Students
			List<Student> stu=session.createQuery("from Student").list();
			
			//display the students
			displayStudents(stu);
			
			//query students : lastname="kumar"
			stu = session.createQuery("from Student where lname='kumar' ").list();
			
			//display the students
			System.out.println("\nStudents having last name of kumar");
			displayStudents(stu);
			
			//query students : lastname="kumar" OR firstname="rakesh"
			stu = session.createQuery("from Student where "
					                  + " lname='awasthi' OR fname='Rakesh'").list();
			
			//display the students
			System.out.println("\nStudents having Email ends with 'gmail.com'");
			displayStudents(stu);
			
			//query students : where email like '%gmail.com'
			stu = session.createQuery("from Student where "
					                  + " email LIKE '%gmail.com'").list();
			
			//display the students
			System.out.println("\nStudents having last name of awasthi Or first name is rakesh");
			displayStudents(stu);

			
			
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!!!");
		} finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> stu) {
		for (Student student : stu) {
			System.out.println(student);
		}
	}

}
