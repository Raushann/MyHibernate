package com.RaushanHibernate.CRUD.Operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {
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
			
			//delete the student
		/*	System.out.println("Deleting Student : "+details);
			session.delete(details); */
			
			//deleting student where id =2 
			System.out.println("Deleting student where id = 2");
			session.createQuery("delete from Student where id=2")
			                   .executeUpdate();
			
			
			//commit the transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!!!!");
		} finally {
			factory.close();
		}
		
	}

}
