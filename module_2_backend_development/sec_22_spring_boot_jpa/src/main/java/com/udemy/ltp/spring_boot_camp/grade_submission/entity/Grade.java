package com.udemy.ltp.spring_boot_camp.grade_submission.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "grade")
public class Grade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "score", nullable = false)
	private String score;

	@ManyToOne(optional = false)
	@JoinColumn(referencedColumnName = "id", name = "student_id")
	private Student student;
}
