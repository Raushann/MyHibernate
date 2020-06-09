package com.RaushanHibernate.CRUD.Operation;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Entity
public class CreateStudent {
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
			
			Student student=new Student("Raushan", "Kumar", "raushan@testyantra.com");
	
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the Student");
			session.save(student);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!!!");
		} finally {
			factory.close();
		}
		
	}

}
