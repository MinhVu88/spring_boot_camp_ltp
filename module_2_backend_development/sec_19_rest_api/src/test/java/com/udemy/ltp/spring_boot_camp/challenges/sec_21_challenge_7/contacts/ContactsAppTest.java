package com.udemy.ltp.spring_boot_camp.challenges.sec_21_challenge_7.contacts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udemy.ltp.spring_boot_camp.challenges.sec_20_challenge_6.contacts.ContactsApp;
import com.udemy.ltp.spring_boot_camp.challenges.sec_20_challenge_6.contacts.pojo.Contact;
import com.udemy.ltp.spring_boot_camp.challenges.sec_20_challenge_6.contacts.repo.ContactRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = ContactsApp.class)
@AutoConfigureMockMvc
public class ContactsAppTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ContactRepository contactRepository;

	private Contact[] contacts = new Contact[] {
		new Contact("1", "Maynard Keenan", "123"),
		new Contact("2", "Adam Jones", "456"),
		new Contact("3", "Dan Carey", "789"),
		new Contact("4", "Paul D'Amour", "101112")
	};

	@BeforeEach
	void setUpEach(){
		for (Contact contact : contacts) {
			contactRepository.saveContact(contact);
		}
	}

	@AfterEach
	void cleanUpEach(){
		contactRepository.getContacts().clear();
	}

	@Test
	public void getContactByIdTest() {
		RequestBuilder request = MockMvcRequestBuilders.get("/contacts/" + contacts[0].getId());

		try {
			mockMvc.perform(request)
						 .andExpect(status().isOk())
						 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
						 .andExpect(jsonPath("$.name").value(contacts[0].getName()))
						 .andExpect(jsonPath("$.phoneNumber").value(contacts[0].getPhoneNumber()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void getAllContactsTest() {
		RequestBuilder request = MockMvcRequestBuilders.get("/contacts/");

		try {
			mockMvc.perform(request)
						 .andExpect(status().isOk())
						 .andExpect(content().contentType(MediaType.APPLICATION_JSON))
						 .andExpect(jsonPath("$.size()").value(contacts.length))
						 .andExpect(jsonPath("$.[?(@.id == \"2\" && @.name == \"Adam Jones\" && @.phoneNumber == \"456\")]").exists());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void validContactCreation() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/contacts/new")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(new Contact("Justin Chancellor", "131415")));

		mockMvc.perform(request).andExpect(status().isCreated());
	}

	@Test
	public void invalidContactCreation() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.post("/contacts/new")
			.contentType(MediaType.APPLICATION_JSON)
			.content(objectMapper.writeValueAsString(new Contact("   ", "   ")));

		mockMvc.perform(request).andExpect(status().isBadRequest());
	}

	@Test
	public void contactNotFoundTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/contacts/-1");

		mockMvc.perform(request).andExpect(status().isNotFound());
	}
}
