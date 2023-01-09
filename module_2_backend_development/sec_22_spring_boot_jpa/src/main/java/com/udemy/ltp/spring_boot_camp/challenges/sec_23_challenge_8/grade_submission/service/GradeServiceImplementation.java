package com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.service;

import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.entity.Student;
import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.entity.Course;
import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.entity.Grade;
import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.exception.GradeNotFoundException;
import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.repository.CourseRepository;
import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.repository.GradeRepository;
import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GradeServiceImplementation implements GradeService {
	private GradeRepository gradeRepository;

	private StudentRepository studentRepository;

	private CourseRepository courseRepository;

	@Override
	public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
		Student student = StudentServiceImplementation.unwrapStudent(
			studentRepository.findById(studentId),
			studentId
		);

		Course course = CourseServiceImplementation.unwrapCourse(
			courseRepository.findById(courseId),
			courseId
		);

		grade.setStudent(student);
		grade.setCourse(course);

		return gradeRepository.save(grade);
	}

	@Override
	public Grade getGrade(Long studentId, Long courseId) {
		Optional<Grade> existingGrade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);

		return unwrapGrade(existingGrade, studentId, courseId);
	}

	@Override
	public List<Grade> getOneStudentGrades(Long studentId) {
		return gradeRepository.findByStudentId(studentId);
	}

	@Override
	public List<Grade> getOneCourseGrades(Long courseId) {
		return gradeRepository.findByCourseId(courseId);
	}

	@Override
	public List<Grade> getAllGrades() {
		return (List<Grade>) gradeRepository.findAll();
	}

	@Override
	public Grade updateGrade(String score, Long studentId, Long courseId) {
		Optional<Grade> existingGrade = gradeRepository.findByStudentIdAndCourseId(studentId, courseId);

		Grade potentiallyUpdatedGrade = unwrapGrade(existingGrade, studentId, courseId);

		potentiallyUpdatedGrade.setScore(score);

		return gradeRepository.save(potentiallyUpdatedGrade);
	}

	@Override
	public void deleteGrade(Long studentId, Long courseId) {
		gradeRepository.deleteByStudentIdAndCourseId(studentId, courseId);
	}

	static Grade unwrapGrade(
		Optional<Grade> entity,
		Long studentId,
		Long courseId
	) {
		if(entity.isPresent()) {
			return entity.get();
		} else {
			throw new GradeNotFoundException(studentId, courseId);
		}
	}
}
