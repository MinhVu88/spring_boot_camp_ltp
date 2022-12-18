package com.udemy.ltp.spring_boot_camp.grade_submission.service;

import com.udemy.ltp.spring_boot_camp.grade_submission.entity.Grade;
import com.udemy.ltp.spring_boot_camp.grade_submission.entity.Student;
import com.udemy.ltp.spring_boot_camp.grade_submission.repository.GradeRepository;
import com.udemy.ltp.spring_boot_camp.grade_submission.repository.StudentRepository;
import lombok.AllArgsConstructor;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GradeServiceImplementation implements GradeService {
	// @Autowired
	private GradeRepository gradeRepository;

	// @Autowired
	private StudentRepository studentRepository;

	@Override
	public Grade getGrade(Long studentId, Long courseId) {
		return gradeRepository.findByStudentId(studentId);
	}

	@Override
	public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
		Student student = studentRepository.findById(studentId).orElse(null);

		grade.setStudent(student);

		return gradeRepository.save(grade);
	}

	@Override
	public Grade updateGrade(String score, Long studentId, Long courseId) {
		return null;
	}

	@Override
	public void deleteGrade(Long studentId, Long courseId) {}

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
