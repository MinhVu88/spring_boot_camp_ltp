package com.udemy.ltp.spring_boot_camp.grade_submission.service;

import com.udemy.ltp.spring_boot_camp.grade_submission.entity.Course;

import java.util.List;

public interface CourseService {
	Course getCourse(Long id);
	Course saveCourse(Course course);
	void deleteCourse(Long id);
	List<Course> getCourses();
}