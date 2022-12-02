package com.udemy.ltp.spring_boot_camp.sections.sec_17_react.pojo;

public class Grade {
	private int id;
	private String name;
	private String subject;
	private String score;

	public Grade(int id, String name, String subject, String score) {
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.score = score;
	}

	public Grade() {}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}
}
