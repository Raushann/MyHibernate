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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	//define our fields
	
	//define constructors 
	
	//define getters/setters
	
	//define toString
	
	//annotate fields
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="course_id")
	private List<Review> review;
	
	
	//set up a list of students
	@ManyToMany(fetch = FetchType.LAZY,
			   cascade = {CascadeType.DETACH,
			   CascadeType.MERGE,
			   CascadeType.PERSIST,
			   CascadeType.REFRESH})
	@JoinTable(
			name="course_student",
			joinColumns=@JoinColumn(name="course_id"),
			inverseJoinColumns=@JoinColumn(name="student_id")
			)

	private List<Student> students;
	
	public Course() {
		
	}

	public Course(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstrucotr() {
		return instructor;
	}

	public void setInstrucotr(Instructor instrucotr) {
		this.instructor = instrucotr;
	}
	
	

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}
	
	//add a convenience method
	
	public void addReview(Review theReview) {
		if (review == null) {
			review = new ArrayList();
		}
		review.add(theReview);
		
	}
	
	
	
    //getters and setters for list of student
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	// add a convenience method 
	public void addStudent(Student theStudent) {
		if (students == null) {
			students =new ArrayList();
		}
		students.add(theStudent);
	}
	
	

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
	
	
	
	

}
