package com.udemy.ltp.spring_boot_camp.grade_submission.web;

import com.udemy.ltp.spring_boot_camp.grade_submission.entity.Course;
import com.udemy.ltp.spring_boot_camp.grade_submission.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/course")
public class CourseController {
	private CourseService courseService;

	@PostMapping
	public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
		Course newCourse = courseService.saveCourse(course);

		return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Course> getCourse(@PathVariable Long id) {
		Course existingCourse = courseService.getCourse(id);

		return new ResponseEntity<>(existingCourse, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Course>> getCourses() {
		List<Course> courses = courseService.getCourses();

		return new ResponseEntity<>(courses, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long id) {
		courseService.deleteCourse(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
