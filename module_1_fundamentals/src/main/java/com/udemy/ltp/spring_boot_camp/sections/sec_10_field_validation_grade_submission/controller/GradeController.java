package com.udemy.ltp.spring_boot_camp.sections.sec_10_field_validation_grade_submission.controller;

import com.udemy.ltp.spring_boot_camp.sections.sec_10_field_validation_grade_submission.Constants;
import com.udemy.ltp.spring_boot_camp.sections.sec_10_field_validation_grade_submission.model.Grade;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GradeController {
	List<Grade> grades = new ArrayList<>();

	@GetMapping("/")
	public String getForm(
		Model model,
		@RequestParam(required = false) String id
	) {
		int index = getGradeIndexById(id);

		model.addAttribute(
		"grade",
			index != Constants.NOT_FOUND ? grades.get(index) : new Grade()
		);

		return "form1";
	}

	@GetMapping("/grades")
	public String getGrades(Model model) {
		model.addAttribute("grades", grades);

		return "grades";
	}

	@PostMapping("/handle-submit")
	public String submitForm(@Valid Grade grade, BindingResult result) {
		System.out.println(
			"name: " + grade.getName() +
			" | subject: " + grade.getSubject() +
			" | result.hasErrors() -> " + result.hasErrors()
		);

		if(result.hasErrors()) {
			return "form1";
		}

		int index = getGradeIndexById(grade.getId());

		if(index == Constants.NOT_FOUND) {
			grades.add(grade);
		}else {
			grades.set(index, grade);
		}

		return "redirect:/grades";
	}

	private int getGradeIndexById(String id) {
		for(int i = 0; i < grades.size(); i++) {
			if(grades.get(i).getId().equalsIgnoreCase(id)) {
				return i;
			}
		}

		// index not found
		return Constants.NOT_FOUND;
	}
}
