package com.udemy.ltp.spring_boot_camp.basic_auth.contacts.web;

import java.util.List;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.udemy.ltp.spring_boot_camp.basic_auth.contacts.pojo.Contact;
import com.udemy.ltp.spring_boot_camp.basic_auth.contacts.service.ContactService;
import com.udemy.ltp.spring_boot_camp.basic_auth.contacts.service.ContactServiceImpl;

@RestController
@RequestMapping("/contacts")
public class ContactController {
	private final ContactService contactService;

	public ContactController(ContactServiceImpl contactService) {
		this.contactService = contactService;
	}

	@PostMapping
	public ResponseEntity<Contact> createContact(@Valid @RequestBody Contact contact) {
		contactService.saveContact(contact);
		return new ResponseEntity<>(contact, HttpStatus.CREATED);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Contact> getContact(@PathVariable String id) {
		Contact contact = contactService.getContactById(id);
		return new ResponseEntity<>(contact, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Contact>> getContacts() {
		List<Contact> contacts = contactService.getContacts();
		return new ResponseEntity<>(contacts, HttpStatus.OK);
	}

	// @DeleteMapping("/{id}")
	@DeleteMapping("/delete/{id}") // a path demo for antMatchers in SecurityConfig.java
	public ResponseEntity<HttpStatus> deleteContact(@PathVariable String id) {
		contactService.deleteContact(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}