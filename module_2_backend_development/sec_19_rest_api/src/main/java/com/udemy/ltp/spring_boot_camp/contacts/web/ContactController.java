package com.udemy.ltp.spring_boot_camp.contacts.web;

import com.udemy.ltp.spring_boot_camp.contacts.pojo.Contact;
import com.udemy.ltp.spring_boot_camp.contacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.ResponseBody;

@RestController
// @Controller
// @ResponseBody
public class ContactController {
	@Autowired
	private ContactService contactService;

	/*
	@GetMapping("/contact/{id}")
	public void getContact(@PathVariable String id) {
		System.out.println(id);
	}
	*/

	/*
	@GetMapping("/contact/{id}")
	@ResponseBody
	public Contact getContact(@PathVariable String id) {
		return new Contact("1", "Maynard Keenan", "123");
	}
  */

	/*
	@GetMapping("/contact/{id}")
	public Contact getContact(@PathVariable String id) {
		return new Contact("1", "Maynard Keenan", "123");
	}
	*/

	@GetMapping("/contact/{id}")
	public ResponseEntity<Contact> getContact(@PathVariable String id) {
		Contact contact = contactService.getContactById(id);

		return new ResponseEntity<>(contact, HttpStatus.OK);
	}
}
