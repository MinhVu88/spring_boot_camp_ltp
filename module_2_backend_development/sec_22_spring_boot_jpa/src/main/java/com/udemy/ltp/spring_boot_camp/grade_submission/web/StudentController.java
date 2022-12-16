package com.udemy.ltp.spring_boot_camp.grade_submission.web;

import com.udemy.ltp.spring_boot_camp.grade_submission.entity.Student;
import com.udemy.ltp.spring_boot_camp.grade_submission.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	StudentService studentService;

	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		Student newStudent = studentService.saveStudent(student);

		return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Long id) {
		Student currentStudent = studentService.getStudent(id);

		return new ResponseEntity<>(currentStudent, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> students = studentService.getStudents();

		return new ResponseEntity<>(students, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
