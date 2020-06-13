package com.RaushanHibernate.EntityMain;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Entity.Instructor;
import com.hibernate.Entity.InstructorDetail;

@Entity
public class CreateDemo {
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

			// Create the objects

			/*
			 * Instructor instructor=new Instructor("Raushan","Singh","Raushan@testyantra.cm");
			 * 
			 * InstructorDetail instructordetail=new InstructorDetail("www.qspiders.com","Testing");
			 */

			//update another object

			Instructor instructor=new Instructor("Abhishek","Singh", "abhishek@fintellix.cm");

			InstructorDetail instructordetail=new InstructorDetail("www.fintellix.com", "Developer");

			// Associate the objects
			instructor.setInstructorDetail(instructordetail);



			//Start a transaction
			session.beginTransaction();

			//Save the instructor

			/* this will also save the details object because of CASCADE.ALL 
			 * 
			 */
			System.out.println("Saving instructor : "+instructor );
			session.save(instructor);


			//commit transaction
			session.getTransaction().commit();

			System.out.println("Done!!!!");
		} finally {
			factory.close();
		}

	}

}
