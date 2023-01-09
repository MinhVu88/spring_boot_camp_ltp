package com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.repository;

import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {}
