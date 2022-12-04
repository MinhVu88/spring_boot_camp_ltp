package com.udemy.ltp.spring_boot_camp.contacts.repository;

import java.util.Arrays;
import java.util.List;

import com.udemy.ltp.spring_boot_camp.contacts.pojo.Contact;
import org.springframework.stereotype.Repository;

@Repository
public class ContactRepository {
	private List<Contact> contacts = Arrays.asList(
		new Contact("1", "Maynard Keenan", "123"),
		new Contact("2", "Adam Jones", "456"),
		new Contact("3", "Dan Carey", "789"),
	  new Contact("4", "Paul D'Amour", "101112"),
		new Contact("5", "Justin Chancellor", "131415")
	);

	public List<Contact> getContacts() {
		return contacts;
	}

	public Contact getContact(int index) {
		return contacts.get(index);
	}

	public void saveContact(Contact contact) {
		contacts.add(contact);
	}

	public void updateContact(int index, Contact contact) {
		contacts.set(index, contact);
	}

	public void deleteContact(int index) {
		contacts.remove(index);
	}
}
