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


public class AddCourseForStudentRaushan {
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
			int studentId=1;
			Student student1=session.get(Student.class, studentId);
			System.out.println("\nLoaded Student : "+student1);
			System.out.println("Courses : "+student1.getCourses());
			
			
			//create more courses
			Course course1=new Course("Core Java- For Beginners");
			Course course2=new Course("J2EE- For Beginners");
			
			//add student to courses
			course1.addStudent(student1);
			course2.addStudent(student1);
			
			//save the courses
            System.out.println("\n Saving the courses");
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
