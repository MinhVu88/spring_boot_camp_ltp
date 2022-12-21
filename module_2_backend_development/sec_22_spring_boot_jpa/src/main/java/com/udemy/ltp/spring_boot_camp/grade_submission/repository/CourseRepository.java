package com.udemy.ltp.spring_boot_camp.grade_submission.repository;

import com.udemy.ltp.spring_boot_camp.grade_submission.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {}
