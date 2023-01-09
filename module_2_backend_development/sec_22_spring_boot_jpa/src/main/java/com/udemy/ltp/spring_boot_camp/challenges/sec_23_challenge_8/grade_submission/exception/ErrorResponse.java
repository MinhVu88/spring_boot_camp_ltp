package com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {
	@JsonFormat(
		shape = JsonFormat.Shape.STRING,
		pattern = "dd-MM-yyyy hh:mm:ss"
	)
	private LocalDateTime timestamp;

	private List<String> messages;

	public ErrorResponse(List<String> messages) {
		this.timestamp = LocalDateTime.now();
		this.messages = messages;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
}
