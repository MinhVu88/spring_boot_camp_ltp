package com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.exception;

public class StudentNotFoundException extends RuntimeException {
	public StudentNotFoundException(Long id) {
		super("The student id '" + id + "' does not exist in our records");
	}
}