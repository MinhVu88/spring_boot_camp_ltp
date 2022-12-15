package com.udemy.ltp.spring_boot_camp.workbooks.workbook_8_1.contacts.web;

import com.udemy.ltp.spring_boot_camp.contacts.pojo.Contact;
import com.udemy.ltp.spring_boot_camp.workbooks.workbook_8_1.contacts.exception.NoContactException;
import com.udemy.ltp.spring_boot_camp.workbooks.workbook_8_1.contacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {
	@Autowired
	private ContactService contactService;

	@GetMapping("/contacts/{id}")
	public ResponseEntity<Contact> getContact(@PathVariable String id) {
		try {
			Contact contact = contactService.getContactById(id);

			System.out.println("GET \"/contacts/{id}\" -> " + contact.toString());

			return new ResponseEntity<>(contact, HttpStatus.OK);
		} catch(NoContactException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/contacts")
	public ResponseEntity<List<Contact>> getContacts() {
		List<Contact> contacts = contactService.getAllContacts();

		System.out.println("GET \"/contacts\" -> " + contacts.toString());

		return new ResponseEntity<>(contacts, HttpStatus.OK);
	}

	@PostMapping("/contacts/new")
	public ResponseEntity<HttpStatus> createContact(@RequestBody Contact contact) {
		contactService.saveContact(contact);

		System.out.println("POST \"/contacts/new\" -> " + contact.toString());

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/contacts/{id}")
	public ResponseEntity<Contact> updateContact(
		@PathVariable String id,
		@RequestBody Contact contact
	) {
		try {
			contactService.updateContact(id, contact);

			System.out.println("PUT \"/contacts/{id}\" -> " + contact.toString());

			return new ResponseEntity<>(contactService.getContactById(id), HttpStatus.OK);
		} catch(NoContactException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/contacts/{id}")
	public ResponseEntity<HttpStatus> deleteContact(@PathVariable String id) {
		try {
			contactService.deleteContact(id);

			System.out.println("DELETE \"/contacts/{id}\" -> id: " + id);

			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch(NoContactException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/contacts")
	public ResponseEntity<HttpStatus> deleteAllContacts() {
		contactService.deleteAllContacts();

		System.out.println("DELETE \"/contacts\" -> " + contactService.getAllContacts());

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
