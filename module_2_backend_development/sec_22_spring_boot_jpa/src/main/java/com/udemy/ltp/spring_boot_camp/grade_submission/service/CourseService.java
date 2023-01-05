package com.udemy.ltp.spring_boot_camp.grade_submission.service;

import com.udemy.ltp.spring_boot_camp.grade_submission.entity.Course;

import java.util.List;

public interface CourseService {
	Course saveCourse(Course course);
	Course getCourse(Long id);
	List<Course> getCourses();
	void deleteCourse(Long id);
}