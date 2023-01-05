package com.udemy.ltp.spring_boot_camp.grade_submission.service;

import com.udemy.ltp.spring_boot_camp.grade_submission.entity.Grade;

import java.util.List;

public interface GradeService {
	Grade saveGrade(Grade grade, Long studentId, Long courseId);
	Grade getGrade(Long studentId, Long courseId);
	List<Grade> getOneStudentGrades(Long studentId);
	List<Grade> getOneCourseGrades(Long courseId);
	List<Grade> getAllGrades();
	Grade updateGrade(String score, Long studentId, Long courseId);
	void deleteGrade(Long studentId, Long courseId);
}
