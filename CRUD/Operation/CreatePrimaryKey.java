package com.RaushanHibernate.CRUD.Operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreatePrimaryKey {
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
			
			//create 3 student object
			System.out.println("Creating Three new Student object");
			
			Student student1=new Student("Moyn", "Razvi", "Moyn@testyantra.com");
			Student student2=new Student("Rahul", "Kumar", "rahul@gmail.com");
			Student student3=new Student("Kaushal", "Kumar", "kaushal@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the Student");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			//commit transaction
			session.getTransaction().commit();
			System.out.println("Done!!!!");
		} finally {
			factory.close();
		}
	
		
	/*	1)How to Change the auto-increment Starting index. 
	      ALTER TABLE db_name.table_name AUTO_INCREMENT=1000;(write in mysql)
	   
	   2)How to Reset the auto-increment index to 1.
	      truncate db_name.table_name;

	 */
		
		
		
		
	}

}
