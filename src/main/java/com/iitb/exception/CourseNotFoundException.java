package com.iitb.exception;

public class CourseNotFoundException extends Exception {

	String msg;

	public CourseNotFoundException(String noCustomers) {
		super("Could not found the Task with id ");
		this.msg = noCustomers;
	}
	
	
	

}
