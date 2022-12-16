package com.udemy.ltp.spring_boot_camp.grade_submission.service;

import com.udemy.ltp.spring_boot_camp.grade_submission.entity.Student;
import com.udemy.ltp.spring_boot_camp.grade_submission.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudent(Long id) {
		Optional<Student> student = studentRepository.findById(id);

		return student.orElse(null);
	}

	@Override
	public List<Student> getStudents() {
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}
}
