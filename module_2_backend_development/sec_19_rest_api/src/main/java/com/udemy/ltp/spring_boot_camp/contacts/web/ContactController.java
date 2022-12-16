package com.udemy.ltp.spring_boot_camp.contacts.web;

import com.udemy.ltp.spring_boot_camp.contacts.pojo.Contact;
import com.udemy.ltp.spring_boot_camp.contacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
// import org.springframework.web.bind.annotation.ResponseBody;

@RestController
// @Controller
// @ResponseBody
public class ContactController {
	@Autowired
	private ContactService contactService;

	/*
	@GetMapping("/contacts/{id}")
	public void getContact(@PathVariable String id) {
		System.out.println(id);
	}
	*/

	/*
	@GetMapping("/contacts/{id}")
	@ResponseBody
	public Contact getContact(@PathVariable String id) {
		return new Contact("1", "Maynard Keenan", "123");
	}
  */

	/*
	@GetMapping("/contacts/{id}")
	public Contact getContact(@PathVariable String id) {
		return new Contact("1", "Maynard Keenan", "123");
	}
	*/

	@GetMapping("/contacts/{id}")
	public ResponseEntity<Contact> getContact(@PathVariable String id) {
		Contact contact = contactService.getContactById(id);

		System.out.println("GET \"/contacts/{id}\" -> " + contact.toString());

		return new ResponseEntity<>(contact, HttpStatus.OK);
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
		contactService.updateContact(id, contact);

		System.out.println("PUT \"/contacts/{id}\" -> " + contact.toString());

		return new ResponseEntity<>(contactService.getContactById(id), HttpStatus.OK);
	}

	@DeleteMapping("/contacts/{id}")
	public ResponseEntity<HttpStatus> deleteContact(@PathVariable String id) {
		contactService.deleteContact(id);

		System.out.println("DELETE \"/contacts/{id}\" -> id: " + id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/contacts")
	public ResponseEntity<HttpStatus> deleteAllContacts() {
		contactService.deleteAllContacts();

		System.out.println("DELETE \"/contacts\" -> " + contactService.getAllContacts());

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
