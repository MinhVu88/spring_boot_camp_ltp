package com.udemy.ltp.spring_boot_camp.challenges.sec_20_challenge_6.contacts.web;

import com.udemy.ltp.spring_boot_camp.challenges.sec_20_challenge_6.contacts.exception.ErrorResponse;
import com.udemy.ltp.spring_boot_camp.challenges.sec_20_challenge_6.contacts.exception.NoContactException;
import com.udemy.ltp.spring_boot_camp.challenges.sec_20_challenge_6.contacts.pojo.Contact;
import com.udemy.ltp.spring_boot_camp.challenges.sec_20_challenge_6.contacts.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Contact Controller", description = "create & retrieve contacts")
public class ContactController {
	@Autowired
	private ContactService contactService;

	// @Tag(name = "Section 1")
	@Operation(
		summary = "Get contact by Id",
		description = "Returns a contact based on an ID"
	)
	@ApiResponses(value = {
		@ApiResponse(
			responseCode = "404",
			description = "Contact doesn't exist",
			content = @Content(schema = @Schema(implementation = ErrorResponse.class))
		),
		@ApiResponse(
			responseCode = "200",
			description = "Successful retrieval of contact",
			content = @Content(schema = @Schema(implementation = Contact.class))
		),
	})
	@GetMapping(
		value = "/contacts/{id}",
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Contact> getContact(@PathVariable String id) {
		try {
			Contact contact = contactService.getContactById(id);

			System.out.println("GET \"/contacts/{id}\" -> " + contact.toString());

			return new ResponseEntity<>(contact, HttpStatus.OK);
		} catch(NoContactException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// @Tag(name = "Section 2")
	@Operation(
		summary = "Retrieves contacts",
		description = "Provides a list of all contacts"
	)
	@ApiResponse(
		responseCode = "200",
		description = "successful retrieval of all contacts",
		content = @Content(array = @ArraySchema(schema = @Schema(implementation = Contact.class)))
	)
	@GetMapping(
		value = "/contacts",
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<List<Contact>> getContacts() {
		List<Contact> contacts = contactService.getAllContacts();

		System.out.println("GET \"/contacts\" -> " + contacts.toString());

		return new ResponseEntity<>(contacts, HttpStatus.OK);
	}

	// @Tag(name = "Section 3")
	@Operation(
		summary = "Create Contact",
		description = "Creates a contact from the provided payload"
	)
	@ApiResponses(value = {
		@ApiResponse(
			responseCode = "201",
			description = "Successful creation of contact"
		),
		@ApiResponse(
			responseCode = "400",
			description = "Bad request: unsuccessful submission",
			content = @Content(schema = @Schema(implementation = ErrorResponse.class))
		)
	})
	@PostMapping(
		value = "/contacts/new",
		produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<HttpStatus> createContact(@RequestBody Contact contact) {
		contactService.saveContact(contact);

		System.out.println("POST \"/contacts/new\" -> " + contact.toString());

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Operation(
		summary = "Update contact by Id",
		description = "Returns an updated contact based on an ID"
	)
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

	@Operation(
		summary = "Delete contact by Id",
		description = "Returns an HTTP status code regarding the operation's outcome"
	)
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

	@Operation(
		summary = "Delete contacts",
		description = "Returns an HTTP status code regarding the operation's outcome"
	)
	@DeleteMapping("/contacts")
	public ResponseEntity<HttpStatus> deleteAllContacts() {
		contactService.deleteAllContacts();

		System.out.println("DELETE \"/contacts\" -> " + contactService.getAllContacts());

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
