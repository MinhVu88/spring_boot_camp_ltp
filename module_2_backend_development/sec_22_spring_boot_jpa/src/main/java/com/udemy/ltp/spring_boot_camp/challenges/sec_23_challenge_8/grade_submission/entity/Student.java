package com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

// @AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", nullable = false)
	@NonNull
	private String name;

	@Column(name = "birth_date", nullable = false)
	@NonNull
	private LocalDate birthDate;

	@JsonIgnore // explained in vid 186
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<Grade> grades;

	/*
	- 1 course can contain Many students. 1 student can enroll in Many courses.

	- In a Many-to-Many relationship, the joining columns (course_id & student_id)
	  are within the join table (course_table).

	- So it doesn't matter which one owns the association.

	- However, for the sake of this challenge, Course owns the association.

	- In order to avoid a recursive loop, add @JsonIgnore to at least 1 side of the relationship.

	- For this exercise, add it to the non-owning side.
	*/
	@JsonIgnore
	@ManyToMany(/*mappedBy = "students"*/) // why comment out mappedBy? Explained in vid 202 Solution
	@JoinTable(
		name = "course_student",
		joinColumns = @JoinColumn(
			name = "student_id",
			referencedColumnName = "id"
		),
		inverseJoinColumns = @JoinColumn(
			name = "course_id",
			referencedColumnName = "id"
		)
	)
	private Set<Course> courses; // Set, instead of List, ensures that the courses a student enrolls in are all unique
}
