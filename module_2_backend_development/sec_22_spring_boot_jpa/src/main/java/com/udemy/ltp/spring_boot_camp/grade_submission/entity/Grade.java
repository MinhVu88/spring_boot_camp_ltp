package com.udemy.ltp.spring_boot_camp.grade_submission.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Grade {
	private Long id;
	private String score;
}
