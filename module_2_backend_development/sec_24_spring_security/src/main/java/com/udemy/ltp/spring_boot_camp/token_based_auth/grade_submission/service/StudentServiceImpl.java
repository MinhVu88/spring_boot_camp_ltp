package com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.entity.Course;
import com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.entity.Student;
import com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.exception.EntityNotFoundException;
import com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.repository.StudentRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
	private StudentRepository studentRepository;

	@Override
	public Student getStudent(Long id) {
		Optional<Student> student = studentRepository.findById(id);
		return unwrapStudent(student, id);
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudent(Long id) {      
		studentRepository.deleteById(id);  
	}

	@Override
	public List<Student> getStudents() {
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public Set<Course> getEnrolledCourses(Long id) {
		Student student = getStudent(id);
		return student.getCourses();
	}

	static Student unwrapStudent(Optional<Student> entity, Long id) {
		if(entity.isPresent()) {
			return entity.get();
		} else {
			throw new EntityNotFoundException(id, Student.class);
		}
	}
}