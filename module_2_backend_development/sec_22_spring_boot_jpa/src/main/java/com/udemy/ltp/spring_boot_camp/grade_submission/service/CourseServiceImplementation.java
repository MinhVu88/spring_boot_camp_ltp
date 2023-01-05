package com.udemy.ltp.spring_boot_camp.grade_submission.service;

import com.udemy.ltp.spring_boot_camp.grade_submission.entity.Course;
import com.udemy.ltp.spring_boot_camp.grade_submission.exception.CourseNotFoundException;
import com.udemy.ltp.spring_boot_camp.grade_submission.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CourseServiceImplementation implements CourseService {
	private CourseRepository courseRepository;

	@Override
	public Course saveCourse(Course course) {
		return courseRepository.save(course);
	}

	@Override
	public Course getCourse(Long id) {
		Optional<Course> course = courseRepository.findById(id);

		/*
		if(course.isPresent()) {
			return course.get();
		} else {
			throw new CourseNotFoundException(id);
		}
		*/

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

	static Course unwrapCourse(Optional<Course> entity, Long id) {
		if(entity.isPresent()) {
			return entity.get();
		} else {
			throw new CourseNotFoundException(id);
		}
	}
}
