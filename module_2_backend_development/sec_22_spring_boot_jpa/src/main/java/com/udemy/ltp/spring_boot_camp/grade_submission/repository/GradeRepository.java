package com.udemy.ltp.spring_boot_camp.grade_submission.repository;

import com.udemy.ltp.spring_boot_camp.grade_submission.entity.Grade;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface GradeRepository extends CrudRepository<Grade, Long> {
	// Grade findByStudentId(Long studentId);
	// Grade findByStudentIdAndCourseId(Long studentId, Long courseId);
	Optional<Grade> findByStudentIdAndCourseId(Long studentId, Long courseId);

	List<Grade> findByStudentId(Long studentId);

	List<Grade> findByCourseId(Long courseId);

	@Transactional
	void deleteByStudentIdAndCourseId(Long studentId, Long courseId);
}
