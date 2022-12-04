package com.udemy.ltp.spring_boot_camp.sections.sec_17_react.web;

import java.util.Arrays;
import java.util.List;

import com.udemy.ltp.spring_boot_camp.sections.sec_17_react.pojo.Grade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class GradeController {
	List<Grade> grades = Arrays.asList(
		new Grade(0, "Harry", "Potions", "C-"),
		new Grade(1, "Hermione", "Arithmancy", "A+"),
		new Grade(2, "Neville", "Charms", "A-")
	);

	@GetMapping("/grades")
	public ResponseEntity<List<Grade>> getGrades() {
		return new ResponseEntity<>(grades, HttpStatus.OK);
	}
}
