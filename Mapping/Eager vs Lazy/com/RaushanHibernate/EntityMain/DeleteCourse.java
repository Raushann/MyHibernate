package com.RaushanHibernate.EntityMain;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Entity.Course;
import com.hibernate.Entity.Instructor;
import com.hibernate.Entity.InstructorDetail;

@Entity
public class DeleteCourse {
	public static void main(String[] args) {
		//create session factory
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		// create Session
		Session session=factory.getCurrentSession();
		try {

			//Start a transaction
			session.beginTransaction();
			
			//get a course
			int id=1;
			Course tempcourse=session.get(Course.class, id);
			
			//delete a course
			System.out.println("Deleting Course : "+tempcourse);
			session.delete(tempcourse);
			
			//commit transaction
			session.getTransaction().commit();

			System.out.println("Done!!!!");
		} finally {
			// add cleanup code
			session.close();
			
			factory.close();
		}

	}

}
