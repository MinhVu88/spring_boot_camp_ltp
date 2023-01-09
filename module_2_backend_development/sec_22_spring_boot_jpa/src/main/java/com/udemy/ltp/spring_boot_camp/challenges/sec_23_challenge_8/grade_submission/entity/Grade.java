package com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.entity;

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
@Table(
	name = "grade",
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"student_id", "course_id"})
	}
)
public class Grade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "score", nullable = false)
	private String score;

	// In the One-to-Many relationship between student & grade, the foreign key lives inside grade.
	// As a result, grade owns the association.
	@ManyToOne(optional = false)
	@JoinColumn(name = "student_id", referencedColumnName = "id")
	private Student student;

	// In the One-to-Many relationship between course & grade, the foreign key column lives inside grade.
	// As a result, grade owns the association.
	@ManyToOne(optional = false)
	@JoinColumn(name = "course_id", referencedColumnName = "id")
	private Course course;
}
