package com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.exception;

public class GradeNotFoundException extends RuntimeException { 
	public GradeNotFoundException(Long studentId, Long courseId) {
		super("The grade with student id: '" + studentId + "' and course id: '" + courseId + "' does not exist in our records");
	}
}