package com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.repository;

import org.springframework.data.repository.CrudRepository;

import com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.entity.Course;

public interface CourseRepository extends CrudRepository<Course, Long> {}