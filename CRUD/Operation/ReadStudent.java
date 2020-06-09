package com.RaushanHibernate.CRUD.Operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent {

	public static void main(String[] args) {
		//create session factory
		SessionFactory factory= new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Student.class)
				                 .buildSessionFactory();
		// create Session
		Session session=factory.getCurrentSession();
		try {
			//use the session Object to save java object
			
			//create a student object
			System.out.println("Creating a new Student object");
			
			Student student=new Student("Rakesh", "Awasthi", "rakesh@testyantra.com");
	
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the Student");
			System.out.println(student);
			session.save(student);
			
			//commit transaction
			session.getTransaction().commit();
			
			//Retrieving Code
			
			// find out the Students id : primary key
			System.out.println("Saved student. Generated id :"+student.getId());
			
			//now get a new Session and start transaction
		    session=factory.getCurrentSession();
			session.beginTransaction();
			
			//Retrieve student based on the id : primary key
			System.out.println("\nGetting Student with id :"+student.getId());
			
			Student details=session.get(Student.class, student.getId());
			System.out.println("Get Complete : "+details);
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!!!");
		} finally {
			factory.close();
		}
		
	}
}
