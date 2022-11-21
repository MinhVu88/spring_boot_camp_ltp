package com.udemy.ltp.spring_boot_camp.sections.sec_10_field_validation;

import com.udemy.ltp.spring_boot_camp.sections.sec_10_field_validation.annotation.Score;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class ScoreValidator implements ConstraintValidator<Score, String> {
	List<String> letterGrades = Arrays.asList(
		"A+", "A", "A-",
		"B+", "B", "B-",
		"C+", "C", "C-",
		"D+", "D", "D-", "F"
	);

	@Override
	public boolean isValid(String score, ConstraintValidatorContext constraintValidatorContext) {
		for(String letterGrade : letterGrades) {
			if(score.equals(letterGrade)) {
				return true;
			}
		}

		return false;
	}
}
