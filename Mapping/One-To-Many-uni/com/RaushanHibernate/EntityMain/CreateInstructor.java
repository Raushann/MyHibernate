package com.RaushanHibernate.EntityMain;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Entity.Course;
import com.hibernate.Entity.Instructor;
import com.hibernate.Entity.InstructorDetail;

@Entity
public class CreateInstructor {
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

			// Create the objects


			Instructor instructor=new Instructor("Suyash","Seth", "Suyash@amdocs.com");

			InstructorDetail instructordetail=new InstructorDetail("www.youtube.com", "Professinal Gamer");

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
			// add cleanup code
			session.close();
			
			factory.close();
		}

	}

}
