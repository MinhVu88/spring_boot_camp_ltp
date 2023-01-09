package com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.validation;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ScoreValidator implements ConstraintValidator<Score, String> {
	List<String> scores = Arrays.asList(
		"A+", "A", "A-", "B+", "B", "B-",
		"C+", "C", "C-", "D+", "D", "D-", "F"
	);

	@Override
	public boolean isValid(
		String value,
		ConstraintValidatorContext context
	) {
		if(value == null) {
			return false;
		}

		for(String score : scores) {
			if(value.equals(score)) {
				return true;
			}
		}

		return false;
	}
}
