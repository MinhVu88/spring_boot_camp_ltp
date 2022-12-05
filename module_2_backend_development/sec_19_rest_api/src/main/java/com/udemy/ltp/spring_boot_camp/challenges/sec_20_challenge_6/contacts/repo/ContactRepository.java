package com.udemy.ltp.spring_boot_camp.challenges.sec_20_challenge_6.contacts.repo;

import com.udemy.ltp.spring_boot_camp.contacts.pojo.Contact;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContactRepository {
	private List<Contact> contacts = new ArrayList<>();

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

	public void deleteContacts() {
		if(contacts.size() > 0) {
			contacts.clear();
		}
	}
}
