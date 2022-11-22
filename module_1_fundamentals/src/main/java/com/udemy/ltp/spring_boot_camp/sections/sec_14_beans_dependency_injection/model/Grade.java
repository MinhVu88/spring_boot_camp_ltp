package com.udemy.ltp.spring_boot_camp.sections.sec_14_beans_dependency_injection.model;

import com.udemy.ltp.spring_boot_camp.sections.sec_14_beans_dependency_injection.annotation.Score;

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

	public Grade() {}

	public Grade(String name, String subject, String score) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.subject = subject;
		this.score = score;
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
