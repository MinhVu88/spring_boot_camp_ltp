package com.udemy.ltp.spring_boot_camp.sections.sec_16_unit_testing.service;

import com.udemy.ltp.spring_boot_camp.sections.sec_14_beans_dependency_injection.Constants;
import com.udemy.ltp.spring_boot_camp.sections.sec_14_beans_dependency_injection.model.Grade;
import com.udemy.ltp.spring_boot_camp.sections.sec_14_beans_dependency_injection.repository.GradeRepo;
import com.udemy.ltp.spring_boot_camp.sections.sec_14_beans_dependency_injection.service.GradeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GradeServiceTest {
	@Mock
	private GradeRepo gradeRepo;

	@InjectMocks
	private GradeService gradeService;

	@Test
	public void getGradesTest() {
		// step 1 -> Arrange: mock the data needed for the unit test
		List<Grade> mockedData = Arrays.asList(
			new Grade("John Doe", "math", "A+"),
			new Grade("Jane Doe", "physics", "A-")
		);

		when(gradeRepo.getGrades()).thenReturn(mockedData);

		// step 2 -> Act: call the method that's tested
		List<Grade> results = gradeService.getGrades();

		// step 3 -> Assert: check if the method behaves properly
		assertEquals("John Doe", results.get(0).getName());
		assertEquals("physics", results.get(1).getSubject());
	}

	@Test
	public void getGradeIndexByIdTest() {
		// Arrange
		when(gradeRepo.getGrades()).thenReturn(
			Arrays.asList(
				new Grade("John Doe", "math", "A+"),
				new Grade("Jane Doe", "physics", "A-")
			)
		);

		List<Grade> results = gradeService.getGrades();

		// Act
		int validIndex = gradeService.getGradeIndexById(results.get(0).getId());
		int invalidIndex = gradeService.getGradeIndexById("-1");

		// Assert
		assertEquals(0, validIndex);
		assertEquals(Constants.NOT_FOUND, invalidIndex);
	}
}
