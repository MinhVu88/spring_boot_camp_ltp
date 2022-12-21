package com.udemy.ltp.spring_boot_camp.grade_submission.entity;

import lombok.*;

import javax.persistence.*;

@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "subject", nullable = false)
	@NonNull
	private String subject;

	@Column(name = "code", nullable = false)
	@NonNull
	private String code;

	@Column(name = "description", nullable = false)
	@NonNull
	private String description;
}
