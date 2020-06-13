package com.RaushanHibernate.EntityMain;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.Entity.Course;
import com.hibernate.Entity.Instructor;
import com.hibernate.Entity.InstructorDetail;

@Entity
public class FetchJoinDemo {
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
			
			//#### Hibernate Query with HQL
			
			
			//get the instructor from db
			int id=1;
			
			Query<Instructor>query=session.createQuery("select i from Instructor i "
					                       + "JOIN FETCH i.courses " 
					                       + "where i.id=:theInstructorId",Instructor.class);
			//set parameter on query
			query.setParameter("theInstructorId", id);
			
			//execute Query and get instructor
			Instructor inst=query.getSingleResult();
			
			System.out.println("Raushan Inst : "+inst);
			
			
                                 
			//commit transaction
			session.getTransaction().commit();
		    
			//close the session
			session.close();
			
			System.out.println("\nHey Now session is closed !!!!!\n");
			
			//since courses are lazy loaded .... this will throw an Exception
			//get course for the instructor
			System.out.println("Raushan Courses : "+inst.getCourses());// recall
			

			System.out.println("Raushan Done!!!!");
		} finally {
			// add cleanup code
			session.close();
			
			factory.close();
		}

	}

}
