package com.udemy.ltp.spring_boot_camp.grade_submission.repository;

import com.udemy.ltp.spring_boot_camp.grade_submission.entity.Grade;
import org.springframework.data.repository.CrudRepository;

public interface GradeRepository extends CrudRepository<Grade, Long> {
	Grade findByStudentId(Long studentId);
}
