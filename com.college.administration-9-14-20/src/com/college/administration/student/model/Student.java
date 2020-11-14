package com.college.administration.student.model;
/**
 * Course Management Rev5!
 * Here we go again!
 * 09/13/20
 * @author MARKR
 *
 */


public class Student {
	
	protected int student_id;
	protected String firstName;
	protected String lastName;
	protected String email;
	
	public Student(){		
	}
		
	public Student(int student_id, String firstName, String lastName, String email) {
		super();
		this.student_id = student_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;			
	}
	
	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;			
	}
	
	

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + student_id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	

}
