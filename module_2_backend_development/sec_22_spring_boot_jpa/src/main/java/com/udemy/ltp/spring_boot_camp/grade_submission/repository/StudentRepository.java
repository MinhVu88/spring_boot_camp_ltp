package com.udemy.ltp.spring_boot_camp.grade_submission.repository;

import com.udemy.ltp.spring_boot_camp.grade_submission.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {}
