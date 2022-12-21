/*
- The relationship between the Student & Grade tables: bidirectional ->
  this provides navigational access from both sides.

- In this relationship, Student is the parent (One-To-Many) ->
  1 student may have many grades.

- On the other hand, Grade is the child (Many-To-One) ->
  many grades may belong to 1 student.

- Furthermore, Grade is the owner of this relationship as it contains
  the foreign keys, which are the primary keys in Student.

- Therefore, mappedBy is applied to Student, but not Grade.

- mappedBy tells Spring JPA not to create any join table as
  there's already a bidirectional relationship between them.
*/
package com.udemy.ltp.spring_boot_camp.grade_submission.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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
}
