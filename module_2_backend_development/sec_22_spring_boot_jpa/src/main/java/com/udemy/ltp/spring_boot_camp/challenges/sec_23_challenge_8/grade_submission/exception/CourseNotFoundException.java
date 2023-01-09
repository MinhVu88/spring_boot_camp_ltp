package com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.exception;

public class CourseNotFoundException extends RuntimeException {
	public CourseNotFoundException(Long id) {
		super("The course id '" + id + "' does not exist in our records");
	}
}