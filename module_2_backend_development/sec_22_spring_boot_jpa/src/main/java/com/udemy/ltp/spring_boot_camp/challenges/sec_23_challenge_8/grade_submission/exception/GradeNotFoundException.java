package com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.exception;

public class GradeNotFoundException extends RuntimeException {
	public GradeNotFoundException(Long studentId, Long courseId) {
		super(
			"The grade with student id: '" + studentId +
			"' and course id: '" + courseId +
			"' does not exist in our records"
		);
	}
}