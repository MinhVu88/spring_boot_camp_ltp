package com.udemy.ltp.spring_boot_camp.basic_auth.contacts.service;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.udemy.ltp.spring_boot_camp.basic_auth.contacts.exception.ContactNotFoundException;
import com.udemy.ltp.spring_boot_camp.basic_auth.contacts.pojo.Contact;
import com.udemy.ltp.spring_boot_camp.basic_auth.contacts.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	private final ContactRepository contactRepository;

	public ContactServiceImpl(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	@Override
	public Contact getContactById(String id) {
		return contactRepository.getContact(findIndexById(id));
	}

	@Override
	public void saveContact(Contact contact) {
		contactRepository.saveContact(contact);
	}

	@Override
	public List<Contact> getContacts() {
		return contactRepository.getContacts();
	}

	@Override
	public void deleteContact(String id) {
		contactRepository.deleteContact(findIndexById(id));
	}

	private int findIndexById(String id) {
		return IntStream.range(0, contactRepository.getContacts().size())
									  .filter(index -> contactRepository.getContacts().get(index).getId().equals(id))
									  .findFirst()
									  .orElseThrow(() -> new ContactNotFoundException(id));
	}
}
