package com.udemy.ltp.spring_boot_camp.grade_submission.service;

import com.udemy.ltp.spring_boot_camp.grade_submission.entity.Course;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CourseServiceImplementation implements CourseService {
	@Override
	public Course getCourse(Long id) {
		return null;
	}

	@Override
	public Course saveCourse(Course course) {
		return null;
	}

	@Override
	public void deleteCourse(Long id) {

	}

	@Override
	public List<Course> getCourses() {
		return null;
	}
}
