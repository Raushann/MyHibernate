package com.hibernate.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor {
	
	// annotate the class

	//define the fields

	//annotate those fields with database column names

	// *** setup mapping to InstructorDetail entity

	//create constructors

	//Generate getters/setters method

	//Generate toString() method
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="first_name")
	private String firstname;

	@Column(name="last_name")
	private String laststname;

	@Column(name="email")
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructorDetail;
	
	@OneToMany(fetch = FetchType.LAZY,
			   mappedBy = "instructor",////refers to "instructor" property in  "course" class.
			   cascade = { CascadeType.DETACH,CascadeType.MERGE,
					       CascadeType.PERSIST,CascadeType.REFRESH})//for not applying cascading delete
	private List<Course> courses;
    // now go to course class

	public Instructor() {

	}


	public Instructor(String firstname, String laststname, String email) {
		this.firstname = firstname;
		this.laststname = laststname;
		this.email = email;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLaststname() {
		return laststname;
	}


	public void setLaststname(String laststname) {
		this.laststname = laststname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}


	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}


	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstname=" + firstname + ", laststname=" + laststname + ", email=" + email
				+ ", instructorDetail=" + instructorDetail + "]";
	}


	public List<Course> getCourses() {
		return courses;
	}


	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

    
	// add convenience method for bi-Directional relationship
	
	public void add(Course tempCourse) {
		
		if (courses == null) {
			courses=new ArrayList();
		}
		courses.add(tempCourse);
		tempCourse.setInstrucotr(this);
		
		
	}





}
