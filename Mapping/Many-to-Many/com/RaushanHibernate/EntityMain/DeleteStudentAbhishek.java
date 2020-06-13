package com.RaushanHibernate.EntityMain;

/*
 Delete a course 
 ## make sure that Students are not deleted.
 ## only delete the Course-Student Realtionship
 
 */
import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Entity.Course;
import com.hibernate.Entity.Instructor;
import com.hibernate.Entity.InstructorDetail;
import com.hibernate.Entity.Review;
import com.hibernate.Entity.Student;


public class DeleteStudentAbhishek {
	public static void main(String[] args) {
		//create session factory
		SessionFactory factory= new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create Session
		Session session=factory.getCurrentSession();
		try {

			//Start a transaction
			session.beginTransaction();
			
			//get the student Raushan from database
			int studentId=2;
			Student student1=session.get(Student.class, studentId);
			System.out.println("\nLoaded Student : "+student1);
			System.out.println("Courses : "+student1.getCourses());
			
			//delete  student
			System.out.println("\n Deleting Student : "+student1 );
			session.delete(student1);
			
			
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
