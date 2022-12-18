package com.udemy.ltp.spring_boot_camp.grade_submission.web;

import com.udemy.ltp.spring_boot_camp.grade_submission.entity.Grade;
import com.udemy.ltp.spring_boot_camp.grade_submission.service.GradeService;
import lombok.AllArgsConstructor;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/grade")
public class GradeController {
	// @Autowired
	private GradeService gradeService;

	@GetMapping("/student/{studentId}/course/{courseId}")
	public ResponseEntity<Grade> getGrade(
		@PathVariable Long studentId,
		@PathVariable Long courseId
	) {
		Grade existingGrade = gradeService.getGrade(studentId, courseId);

		return new ResponseEntity<>(existingGrade, HttpStatus.OK);
	}

	@PostMapping("/student/{studentId}/course/{courseId}")
	public ResponseEntity<Grade> saveGrade(
		@RequestBody Grade grade,
		@PathVariable Long studentId,
		@PathVariable Long courseId
	) {
		Grade newGrade = gradeService.saveGrade(grade, studentId, courseId);

		return new ResponseEntity<>(newGrade, HttpStatus.CREATED);
	}

	@PutMapping("/student/{studentId}/course/{courseId}")
	public ResponseEntity<Grade> updateGrade(
		@RequestBody Grade grade,
		@PathVariable Long studentId,
		@PathVariable Long courseId
	) {
		return new ResponseEntity<>(grade, HttpStatus.OK);
	}

	@DeleteMapping("/student/{studentId}/course/{courseId}")
	public ResponseEntity<HttpStatus> deleteGrade(
		@PathVariable Long studentId,
		@PathVariable Long courseId
	) {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/student/{studentId}")
	public ResponseEntity<List<Grade>> getStudentGrades(@PathVariable Long studentId) {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/course/{courseId}")
	public ResponseEntity<List<Grade>> getCourseGrades(@PathVariable Long courseId) {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Grade>> getGrades() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
