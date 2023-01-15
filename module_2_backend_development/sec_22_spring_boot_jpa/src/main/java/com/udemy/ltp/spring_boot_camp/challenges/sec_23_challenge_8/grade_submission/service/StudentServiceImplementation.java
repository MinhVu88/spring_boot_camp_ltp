package com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.service;

import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.entity.Course;
import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.entity.Student;
import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.exception.StudentNotFoundException;
import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class StudentServiceImplementation implements StudentService {
	private StudentRepository studentRepository;

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudent(Long studentId) {
		Optional<Student> student = studentRepository.findById(studentId);

		return unwrapStudent(student, studentId);
	}

	@Override
	public List<Student> getStudents() {
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public void deleteStudent(Long studentId) {
		studentRepository.deleteById(studentId);
	}

	@Override
	public Set<Course> getEnrolledCourses(Long studentId) {
		Student student = getStudent(studentId);

		return student.getCourses();
	}

	static Student unwrapStudent(Optional<Student> entity, Long studentId) {
		if(entity.isPresent()) {
			return entity.get();
		} else {
			throw new StudentNotFoundException(studentId);
		}
	}
}
