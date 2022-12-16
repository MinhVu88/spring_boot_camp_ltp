package com.udemy.ltp.spring_boot_camp.grade_submission.service;

import com.udemy.ltp.spring_boot_camp.grade_submission.entity.Student;

import java.util.List;

public interface StudentService {
	Student saveStudent(Student student);
	Student getStudent(Long id);
	List<Student> getStudents();
	void deleteStudent(Long id);
}
