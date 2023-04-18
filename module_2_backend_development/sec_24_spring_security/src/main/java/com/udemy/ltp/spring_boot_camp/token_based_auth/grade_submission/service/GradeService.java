package com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.service;

import java.util.List;

import com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.entity.Grade;

public interface GradeService {
	Grade getGrade(Long studentId, Long courseId);

	Grade saveGrade(Grade grade, Long studentId, Long courseId);

	Grade updateGrade(String score, Long studentId, Long courseId);

	void deleteGrade(Long studentId, Long courseId);

	List<Grade> getStudentGrades(Long studentId);

	List<Grade> getCourseGrades(Long courseId);
	
	List<Grade> getAllGrades();
}
