package com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.exception;

public class StudentNotEnrolledException extends RuntimeException {
	public StudentNotEnrolledException(Long studentId, Long courseId) {
		super(
			"The student with id: '" + studentId +
			"' is not enrolled in the course with id: '" + courseId
		);
	}
}
