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
import static org.mockito.Mockito.*;
// import static org.mockito.Mockito.lenient;


@ExtendWith(MockitoExtension.class)
public class GradeServiceTest {
	@Mock
	private GradeRepo mockedGradeRepo;

	@InjectMocks
	private GradeService gradeService; // inject the mocked gradeRepo into gradeService

	@Test
	public void getGradesTest() {
		// step 1 -> Arrange: mock the data needed for the unit test
		List<Grade> expectedResults = Arrays.asList(
			new Grade("John Doe", "math", "A+"),
			new Grade("Jane Doe", "physics", "A-")
		);

		when(mockedGradeRepo.getGrades()).thenReturn(expectedResults);

		// step 2 -> Act: call the method that's meant to be tested
		List<Grade> actualResults = gradeService.getGrades();

		// step 3 -> Assert: check if the method behaves properly
		assertEquals("John Doe", actualResults.get(0).getName());
		assertEquals("physics", actualResults.get(1).getSubject());
	}

	@Test
	public void getGradeIndexByIdTest() {
		// ARRANGE
		Grade expectedResult = new Grade("John Doe", "math", "A+");

		when(mockedGradeRepo.getGrades()).thenReturn(Arrays.asList(expectedResult));
		when(mockedGradeRepo.getGrade(0)).thenReturn(expectedResult);

		// UnnecessaryStubbingException occurs for using approach 1 & can be bypassed by calling lenient()
		// lenient().when(gradeRepo.getGrade(0)).thenReturn(expectedResult);

		// ACT
		int validIndex = gradeService.getGradeIndexById(expectedResult.getId());
		int invalidIndex = gradeService.getGradeIndexById("-1");

		// ASSERT
		assertEquals(0, validIndex);
		assertEquals(Constants.NOT_FOUND, invalidIndex);
	}

	@Test
	public void getGradeByIdTest() {
		// ARRANGE
		Grade expectedResult = new Grade("Jane Doe", "physics", "A-");

		when(mockedGradeRepo.getGrades()).thenReturn(Arrays.asList(expectedResult));
		when(mockedGradeRepo.getGrade(0)).thenReturn(expectedResult);

		// ACT
		Grade actualResult = gradeService.getGradeById(expectedResult.getId());

		// ASSERT
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void submitGradeTest1() {
		// ARRANGE
		Grade expectedResult = new Grade("Layne Staley", "vocal", "A+");

		when(mockedGradeRepo.getGrades()).thenReturn(Arrays.asList(expectedResult));
		when(mockedGradeRepo.getGrade(0)).thenReturn(expectedResult);

		Grade newGrade = new Grade("Jerry Cantrell", "guitar", "A-");

		// ACT
		gradeService.submitGrade(newGrade);

		// ASSERT
		verify(mockedGradeRepo, times(1)).addGrade(newGrade);
	}

	@Test
	public void submitGradeTest2() {
		// ARRANGE
		Grade expectedResult = new Grade("Scott Weiland", "vocal", "C+");

		when(mockedGradeRepo.getGrades()).thenReturn(Arrays.asList(expectedResult));
		when(mockedGradeRepo.getGrade(0)).thenReturn(expectedResult);

		expectedResult.setScore("A+");

		// ACT
		gradeService.submitGrade(expectedResult);

		// ASSERT
		verify(mockedGradeRepo, times(1)).updateGrade(0, expectedResult);
	}
}
