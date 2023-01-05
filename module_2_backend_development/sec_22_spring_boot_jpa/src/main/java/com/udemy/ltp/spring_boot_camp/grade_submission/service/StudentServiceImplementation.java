package com.udemy.ltp.spring_boot_camp.grade_submission.service;

import com.udemy.ltp.spring_boot_camp.grade_submission.entity.Student;
import com.udemy.ltp.spring_boot_camp.grade_submission.exception.StudentNotFoundException;
import com.udemy.ltp.spring_boot_camp.grade_submission.repository.StudentRepository;
import lombok.AllArgsConstructor;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class StudentServiceImplementation implements StudentService {
	// @Autowired
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudent(Long id) {
		Optional<Student> student = studentRepository.findById(id);

		/*
		if(student.isPresent()) {
			return student.get();
		} else {
			throw new StudentNotFoundException(id);
		}
		*/

		return unwrapStudent(student, id);
	}

	@Override
	public List<Student> getStudents() {
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

	static Student unwrapStudent(Optional<Student> entity, Long id) {
		if(entity.isPresent()) {
			return entity.get();
		} else {
			throw new StudentNotFoundException(id);
		}
	}
}
