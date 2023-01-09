package com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.repository;

import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {}
