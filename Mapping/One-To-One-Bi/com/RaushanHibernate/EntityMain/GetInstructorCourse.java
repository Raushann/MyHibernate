package com.RaushanHibernate.EntityMain;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Entity.Course;
import com.hibernate.Entity.Instructor;
import com.hibernate.Entity.InstructorDetail;

@Entity
public class GetInstructorCourse {
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
			
			//get the instructor from db
			int id=1;
			Instructor inst= session.get(Instructor.class, id);
			
			System.out.println("Inst : "+inst);
			
			//get course for the instructor
			System.out.println("Courses : "+inst.getCourses());
                                 
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
