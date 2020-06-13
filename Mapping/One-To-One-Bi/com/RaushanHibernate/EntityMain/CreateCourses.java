package com.RaushanHibernate.EntityMain;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Entity.Course;
import com.hibernate.Entity.Instructor;
import com.hibernate.Entity.InstructorDetail;

@Entity
public class CreateCourses {
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
			
			//create some courses;
			Course course1= new Course("Java - The ultimate Programmer");
			Course course2= new Course("PubG Player");
			
			//add courses to instructor
			inst.add(course1);
			inst.add(course2);
			
			//save the courses
			session.save(course1);
			session.save(course2);
                                 
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
