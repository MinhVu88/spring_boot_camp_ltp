package com.udemy.ltp.spring_boot_camp.sections.sec_16_testing_web_app;

// import com.udemy.ltp.spring_boot_camp.sections.sec_14_beans_dependency_injection.controller.GradeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = {com.udemy.ltp.spring_boot_camp.sections.sec_14_beans_dependency_injection.GradeSubmissionApp.class})
@AutoConfigureMockMvc
public class GradeSubmissionAppTest {
	@Autowired
	private MockMvc mockMvc;

	// @Autowired
	// private GradeController gradeController;

	@Test
	public void contextLoads() {
		// assertNotNull(gradeController);
		assertNotNull(mockMvc);
	}

	// the following integration tests validate the interactions between
	// various layers in this Spring Boot app (presentation, service & data access)
	@Test
	void testGetForm() throws Exception {
		RequestBuilder mockedGetRequest = MockMvcRequestBuilders.get("/?id=123");

		mockMvc.perform(mockedGetRequest)
					 .andExpect(status().is2xxSuccessful())
					 .andExpect(view().name("form1"))
					 .andExpect(model().attributeExists("grade"));

	}

	@Test
	void testGetGrades() throws Exception {
		RequestBuilder mockedGetRequest = MockMvcRequestBuilders.get("/grades");

		mockMvc.perform(mockedGetRequest)
					 .andExpect(status().is2xxSuccessful())
					 .andExpect(view().name("grades"))
					 .andExpect(model().attributeExists("grades"));
	}

	@Test
	void testSuccessfulFormSubmission() throws Exception {
		RequestBuilder mockedPostRequest = MockMvcRequestBuilders.post("/handle-submit")
			.param("name", "Maynard Keenan")
			.param("subject", "math")
			.param("score", "A+");

		mockMvc.perform(mockedPostRequest)
		       .andExpect(status().is3xxRedirection())
					 .andExpect(redirectedUrl("/grades"));
	}

	@Test
	void testUnsuccessfulFormSubmission() throws Exception {
		RequestBuilder mockedPostRequest = MockMvcRequestBuilders.post("/handle-submit")
			.param("name", "")
			.param("subject", "")
			.param("score", "Z-");

		mockMvc.perform(mockedPostRequest)
					 .andExpect(status().is2xxSuccessful())
					 .andExpect(view().name("form1"));
	}
}
