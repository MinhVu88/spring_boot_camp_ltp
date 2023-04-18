package com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.entity.Grade;

public interface GradeRepository extends CrudRepository<Grade, Long> {
	Optional<Grade> findByStudentIdAndCourseId(Long studentId, Long courseId);

	List<Grade> findByStudentId(Long studentId);

	List<Grade> findByCourseId(Long courseId);
	
	@Transactional
	void deleteByStudentIdAndCourseId(Long studentId, Long courseId);
}