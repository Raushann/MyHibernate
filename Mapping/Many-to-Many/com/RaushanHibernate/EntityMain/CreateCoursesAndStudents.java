package com.RaushanHibernate.EntityMain;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Entity.Course;
import com.hibernate.Entity.Instructor;
import com.hibernate.Entity.InstructorDetail;
import com.hibernate.Entity.Review;
import com.hibernate.Entity.Student;


public class CreateCoursesAndStudents {
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
			
			
			
			//create a course
			Course tempCourse=new Course("PubG - How to Become a Pro Player");
			
			//save the course
			System.out.println("\n SAving the course....\n");
			session.save(tempCourse);
			System.out.println("Saved the Course : "+tempCourse);
			
			// create a students
			Student student1=new Student("Raushan", "Kumar", "raushan@testyantra.com");
			Student student2=new Student("Abhishek", "Singh", "abhishek@fintellix.com");
			
			//add students to the course
			tempCourse.addStudent(student1);
			tempCourse.addStudent(student2);
			
			
		   // save the students
			System.out.println("\n SAving the Students....\n");
			session.save(student1);
			session.save(student2);
			System.out.println("Saved Students : "+tempCourse.getStudents());
                                 
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
