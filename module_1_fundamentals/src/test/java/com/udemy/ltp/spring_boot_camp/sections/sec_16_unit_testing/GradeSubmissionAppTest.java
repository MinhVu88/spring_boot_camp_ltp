package com.udemy.ltp.spring_boot_camp.sections.sec_16_unit_testing;

import com.udemy.ltp.spring_boot_camp.sections.sec_14_beans_dependency_injection.controller.GradeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class GradeSubmissionAppTest {
	@Autowired
	private GradeController gradeController;

	@Test
	public void contextLoads() {
		assertNotNull(gradeController);
	}
}
