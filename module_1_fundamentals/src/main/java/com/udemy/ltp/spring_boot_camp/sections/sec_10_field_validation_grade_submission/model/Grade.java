package com.udemy.ltp.spring_boot_camp.sections.sec_10_field_validation_grade_submission.model;

import com.udemy.ltp.spring_boot_camp.sections.sec_10_field_validation_grade_submission.annotation.Score;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Grade {
	private String id;

	@NotBlank(message = "name is required")
	private String name;

	@NotBlank(message = "subject is required")
	private String subject;

	@Score(message = "a score must be a letter grade")
	private String score;

	public Grade() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
}
