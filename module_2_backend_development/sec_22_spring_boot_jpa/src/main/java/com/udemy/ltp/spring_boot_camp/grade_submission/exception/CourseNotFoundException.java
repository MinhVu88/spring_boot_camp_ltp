package com.udemy.ltp.spring_boot_camp.grade_submission.exception;

public class CourseNotFoundException extends RuntimeException {
	public CourseNotFoundException(Long id) {
		super("The course id '" + id + "' does not exist in our records");
	}
}