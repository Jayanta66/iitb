package com.iitb.exception;
/* Created by Arjun Gautam */

public class CourseNotFoundExceptionNow extends RuntimeException{
    public CourseNotFoundExceptionNow(String string){
        super("Could not found the Task with id "+ string);
    }
}
