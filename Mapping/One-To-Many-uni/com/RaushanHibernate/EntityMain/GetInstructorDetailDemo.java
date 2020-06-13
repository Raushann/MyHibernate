package com.RaushanHibernate.EntityMain;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Entity.Instructor;
import com.hibernate.Entity.InstructorDetail;

@Entity
public class GetInstructorDetailDemo {
	public static void main(String[] args) {
		//create session factory
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		// create Session
		Session session=factory.getCurrentSession();
		try {


			//Start a transaction
			session.beginTransaction();
       
			//get the InstructorDetails object
			int id=20;//make sure that is  available in database
			InstructorDetail instdetail=session.get(InstructorDetail.class, id);//return null if not found
			
			//print the instructor detail
			System.out.println("instdetails : "+instdetail);
			
			//print the associated instructor
			System.out.println("the associated instructor : "+instdetail.getInstructor());//NPE
			
			//commit transaction
			session.getTransaction().commit();

			System.out.println("Done!!!!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//handle connection leak issue
			session.close();
			factory.close();
		}

	}

}
