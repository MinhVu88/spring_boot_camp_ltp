package com.udemy.ltp.spring_boot_camp.grade_submission.service;

import com.udemy.ltp.spring_boot_camp.grade_submission.entity.Grade;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImplementation implements GradeService {
	@Override
	public Grade getGrade(Long studentId, Long courseId) {
		return null;
	}

	@Override
	public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
		return null;
	}

	@Override
	public Grade updateGrade(String score, Long studentId, Long courseId) {
		return null;
	}

	@Override
	public void deleteGrade(Long studentId, Long courseId) {

	}

	@Override
	public List<Grade> getStudentGrades(Long studentId) {
		return null;
	}

	@Override
	public List<Grade> getCourseGrades(Long courseId) {
		return null;
	}

	@Override
	public List<Grade> getAllGrades() {
		return null;
	}
}
