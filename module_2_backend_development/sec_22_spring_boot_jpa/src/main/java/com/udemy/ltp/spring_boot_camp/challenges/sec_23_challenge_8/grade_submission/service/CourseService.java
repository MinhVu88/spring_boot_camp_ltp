package com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.service;


import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.entity.Course;
import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.entity.Student;

import java.util.List;
import java.util.Set;

public interface CourseService {
	Course saveCourse(Course course);
	Course getCourse(Long courseId);
	List<Course> getCourses();
	void deleteCourse(Long courseId);
	Course addStudentToCourse(Long studentId, Long courseId);
	Set<Student> getEnrolledStudents(Long courseId);
}