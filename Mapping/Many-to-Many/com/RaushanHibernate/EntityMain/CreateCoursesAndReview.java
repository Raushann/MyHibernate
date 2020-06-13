package com.RaushanHibernate.EntityMain;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Entity.Course;
import com.hibernate.Entity.Instructor;
import com.hibernate.Entity.InstructorDetail;
import com.hibernate.Entity.Review;


public class CreateCoursesAndReview {
	public static void main(String[] args) {
		//create session factory
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		// create Session
		Session session=factory.getCurrentSession();
		try {

			//Start a transaction
			session.beginTransaction();
			
			//create a course
			Course tempCourse=new Course("PubG - How to Become a Pro Player");
			
			//add some reviews
			tempCourse.addReview(new Review("Great Game "));
			tempCourse.addReview(new Review("Awesome Game,  i would like to play "));
			tempCourse.addReview(new Review("Fucking game i hate this game "));
			
			//save the course ... and leverage the cascade all
			System.out.println("Saving the Course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReview());
			
			session.save(tempCourse);
			
                                 
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
