package com.udemy.ltp.spring_boot_camp.grade_submission.exception;

public class StudentNotFoundException extends RuntimeException {
	public StudentNotFoundException(Long id) {
		super("The student id '" + id + "' does not exist in our records");
	}
}