package com.udemy.ltp.spring_boot_camp.grade_submission.web;

import com.udemy.ltp.spring_boot_camp.grade_submission.entity.Course;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
	@GetMapping("/{id}")
	public ResponseEntity<Course> getCourse(@PathVariable Long id) {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
		return new ResponseEntity<>(course, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long id) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Course>> getCourses() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
