package com.RaushanHibernate.EntityMain;

import javax.persistence.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Entity.Instructor;
import com.hibernate.Entity.InstructorDetail;

@Entity
public class DeleteDemo {
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
       
			//get instructor by primary key / id
			int id=1;
			
			Instructor ins=session.get(Instructor.class, id);
			System.out.println("Found Instructor : "+ins);
			
			// delete the instructors
			if(ins != null) {
				System.out.println("Deleting : "+ins);
				/*Note:-
				  this will also delete associated "details" object 
		           because of CascadeType.ALL
				 */
				session.delete(ins);
			}


			//commit transaction
			session.getTransaction().commit();

			System.out.println("Done!!!!");
		} finally {
			factory.close();
		}

	}

}
