package com.RaushanHibernate.CRUD.Operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudent {
	public static void main(String[] args) {
		//create session factory
		SessionFactory factory= new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		// create Session
		Session session=factory.getCurrentSession();
		try {
			int studentId=1;
			
			//start a transaction
			session.beginTransaction();
			
			//now get a new Session and start transaction
		    session=factory.getCurrentSession();
			
			//Retrieve student based on the id : primary key
			System.out.println("\nGetting Student with id :"+studentId );
			
			Student details=session.get(Student.class, studentId);
			
			//update students firstname where id=1
			
			System.out.println("Updating Student...........");
			details.setFname("Baajirao");
			
			//commit the transaction
			session.getTransaction().commit();
			
			
			// New Code
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			//update email for all students
			System.out.println("Update Email For all Students");
			session.createQuery("update Student set email='testing@qspiders.com'")
			                    .executeUpdate();//used for update or delete
			
			//commit the transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!!!!");
		} finally {
			factory.close();
		}
		
	}

}
