package com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.service;


import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.entity.Course;
import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.entity.Student;

import java.util.List;

public interface StudentService {
	Student saveStudent(Student student);
	Student getStudent(Long studentId);
	List<Student> getStudents();
	void deleteStudent(Long studentId);
	List<Course> getEnrolledCourses(Long studentId);
}
