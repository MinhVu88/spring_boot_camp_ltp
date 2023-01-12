package com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.service;

import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.entity.Course;
import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.entity.Student;
import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.exception.CourseNotFoundException;
import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.repository.CourseRepository;
import com.udemy.ltp.spring_boot_camp.challenges.sec_23_challenge_8.grade_submission.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
@Service
public class CourseServiceImplementation implements CourseService {
	private CourseRepository courseRepository;
	private StudentRepository studentRepository;

	@Override
	public Course saveCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Course getCourse(Long id) {
		Optional<Course> course = courseRepository.findById(id);

		return unwrapCourse(course, id);
	}

	@Override
	public List<Course> getCourses() {
		return (List<Course>) courseRepository.findAll();
	}

	@Override
	public void deleteCourse(Long id) {
		courseRepository.deleteById(id);
	}

	@Override
	public Course addStudentToCourse(Long studentId, Long courseId) {
		Course course = getCourse(courseId);

		Student newStudent = StudentServiceImplementation.unwrapStudent(
			studentRepository.findById(studentId),
			studentId
		);

		Set<Student> currentEnrolledStudents = course.getStudents();

		currentEnrolledStudents.add(newStudent);

		// save the modified course to the db
		return courseRepository.save(course);
	}

	static Course unwrapCourse(Optional<Course> entity, Long id) {
		if(entity.isPresent()) {
			return entity.get();
		} else {
			throw new CourseNotFoundException(id);
		}
	}
}
