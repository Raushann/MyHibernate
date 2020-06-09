package com.RaushanHibernate.CRUD.Operation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
