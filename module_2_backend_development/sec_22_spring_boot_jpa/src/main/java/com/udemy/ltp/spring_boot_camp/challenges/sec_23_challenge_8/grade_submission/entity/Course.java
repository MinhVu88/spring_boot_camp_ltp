package com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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

	@Column(name = "code", nullable = false, unique = true)
	@NonNull
	private String code;

	@Column(name = "description", nullable = false)
	@NonNull
	private String description;

	@JsonIgnore
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<Grade> grades;

	/*
	- 1 student can enroll in Many courses. 1 course can contain Many students.

	- In a Many-to-Many relationship, the joining columns (course_id & student_id)
	  are within the join table (course_table).

	- So it doesn't matter which one owns the association.

	- However, for the sake of this challenge, Course owns the association.

	- Set joinColumns equal to a foreign-key column (via @JoinColumn) that
	  references the primary table of the entity, which owns the association (Course).

	- Set inverseJoinColumns equal to a foreign-key column (via @JoinColumn) that
	  references the primary table of the entity, which does NOT own the association (Student).
	*/
	@ManyToMany
	@JoinTable(
		name = "course_student",
		joinColumns = @JoinColumn(
			name = "course_id",
			referencedColumnName = "id"
		),
		inverseJoinColumns = @JoinColumn(
			name = "student_id",
			referencedColumnName = "id"
		)
	)
	private Set<Student> students;
}
