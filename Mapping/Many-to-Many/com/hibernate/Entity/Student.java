package com.hibernate.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="StudentHibernate")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="First_Name")
	private String fname;
	
	@Column(name="Last_Name")
	private String lname;
	
	@Column(name="Email_Id")
	private String email;

	//set up a list of Courses
	@ManyToMany(fetch = FetchType.LAZY,
			   cascade = {CascadeType.DETACH,
			   CascadeType.MERGE,
			   CascadeType.PERSIST,
			   CascadeType.REFRESH})
	@JoinTable(
			name="course_student",
			joinColumns=@JoinColumn(name="student_id"),
			inverseJoinColumns=@JoinColumn(name="course_id")
			)

	private List<Course> courses;
	
	Student(){

	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Student(String fname, String lname, String email) {
		this.fname = fname;
		this.lname = lname;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Student [fname=" + fname + ", lname=" + lname + ", email=" + email + "]";
	}





}
