package com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.web;

import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.entity.Grade;
import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.service.GradeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/grade")
public class GradeController {
	private GradeService gradeService;

	@PostMapping("/student/{studentId}/course/{courseId}")
	public ResponseEntity<Grade> saveGrade(
		@RequestBody Grade grade,
		@PathVariable Long studentId,
		@PathVariable Long courseId
	) {
		Grade newGrade = gradeService.saveGrade(grade, studentId, courseId);

		return new ResponseEntity<>(newGrade, HttpStatus.CREATED);
	}

	@GetMapping("/student/{studentId}/course/{courseId}")
	public ResponseEntity<Grade> getGrade(
		@PathVariable Long studentId,
		@PathVariable Long courseId
	) {
		Grade existingGrade = gradeService.getGrade(studentId, courseId);

		return new ResponseEntity<>(existingGrade, HttpStatus.OK);
	}

	@GetMapping("/student/{studentId}")
	public ResponseEntity<List<Grade>> getOneStudentGrades(@PathVariable Long studentId) {
		List<Grade> oneStudentGrades = gradeService.getOneStudentGrades(studentId);

		return new ResponseEntity<>(oneStudentGrades, HttpStatus.OK);
	}

	@GetMapping("/course/{courseId}")
	public ResponseEntity<List<Grade>> getOneCourseGrades(@PathVariable Long courseId) {
		List<Grade> oneCourseGrades = gradeService.getOneCourseGrades(courseId);

		return new ResponseEntity<>(oneCourseGrades, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Grade>> getGrades() {
		List<Grade> allGrades = gradeService.getAllGrades();

		return new ResponseEntity<>(allGrades, HttpStatus.OK);
	}

	@PutMapping("/student/{studentId}/course/{courseId}")
	public ResponseEntity<Grade> updateGrade(
		@RequestBody Grade grade,
		@PathVariable Long studentId,
		@PathVariable Long courseId
	) {
		String newScore = grade.getScore();

		Grade updatedGrade = gradeService.updateGrade(newScore, studentId, courseId);

		return new ResponseEntity<>(updatedGrade, HttpStatus.OK);
	}

	@DeleteMapping("/student/{studentId}/course/{courseId}")
	public ResponseEntity<HttpStatus> deleteGrade(
		@PathVariable Long studentId,
		@PathVariable Long courseId
	) {
		gradeService.deleteGrade(studentId, courseId);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
