package com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.web;

import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.entity.Course;
import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.entity.Student;
import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.service.CourseService;
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

	@GetMapping("/{courseId}")
	public ResponseEntity<Course> getCourse(@PathVariable Long courseId) {
		Course existingCourse = courseService.getCourse(courseId);

		return new ResponseEntity<>(existingCourse, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Course>> getCourses() {
		List<Course> courses = courseService.getCourses();

		return new ResponseEntity<>(courses, HttpStatus.OK);
	}

	@GetMapping("/{courseId}/students")
	public ResponseEntity<List<Student>> getEnrolledStudents(@PathVariable Long courseId) {

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/{courseId}/student/{studentId}")
	public ResponseEntity<Course> enrollStudentInCourse(
		@PathVariable Long courseId,
		@PathVariable Long studentId
	) {
		Course modifiedCourse = courseService.addStudentToCourse(studentId, courseId);

		return new ResponseEntity<>(modifiedCourse, HttpStatus.OK);
	}

	@DeleteMapping("/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable Long courseId) {
		courseService.deleteCourse(courseId);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
