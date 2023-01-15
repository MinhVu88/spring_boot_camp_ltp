package com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.web;

import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.entity.Course;
import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.entity.Student;
import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/student")
public class StudentController {
	private StudentService studentService;

	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		Student newStudent = studentService.saveStudent(student);

		return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
	}

	@GetMapping("/{studentId}")
	public ResponseEntity<Student> getStudent(@PathVariable Long studentId) {
		Student existingStudent = studentService.getStudent(studentId);

		return new ResponseEntity<>(existingStudent, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> students = studentService.getStudents();

		return new ResponseEntity<>(students, HttpStatus.OK);
	}

	@GetMapping("/{studentId}/courses")
	public ResponseEntity<Set<Course>> getEnrolledCourses(@PathVariable Long studentId) {
		Set<Course> enrolledCourses = studentService.getEnrolledCourses(studentId);

		return new ResponseEntity<>(enrolledCourses, HttpStatus.OK);
	}

	@DeleteMapping("/{studentId}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long studentId) {
		studentService.deleteStudent(studentId);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
