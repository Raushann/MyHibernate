package com.hibernate.Entity;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
	// annotate the class
	
	//define the fields
	
	//annotate those fields with database column names
	
	//create constructors
	
	//Generate getters/setters method
	
	//Generate toString() method
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubechannel;
	
	@Column(name="hobby")
	private String hobby;
	
	// add new field for instructor (also add getter/setter)
	
	// add @oneToOne annotation
	
	//@OneToOne(mappedBy = "instructorDetail",cascade = CascadeType.ALL)
	/* refers to "instructorDetail property in "instructor class"
	   Cascade all the operations to the associated instructor */
	@OneToOne(mappedBy = "instructorDetail",cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH })
	private Instructor instructor;
	
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	
	
	public InstructorDetail() {
		
	}

	public InstructorDetail(String youtubechannel, String hobby) {
		this.youtubechannel = youtubechannel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubechannel() {
		return youtubechannel;
	}

	public void setYoutubechannel(String youtubechannel) {
		this.youtubechannel = youtubechannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubechannel=" + youtubechannel + ", hobby=" + hobby + "]";
	}
	
	
	
	
	

}
