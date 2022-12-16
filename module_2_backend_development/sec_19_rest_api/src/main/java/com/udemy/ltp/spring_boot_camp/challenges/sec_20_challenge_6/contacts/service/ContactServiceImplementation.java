package com.udemy.ltp.spring_boot_camp.challenges.sec_20_challenge_6.contacts.service;

import com.udemy.ltp.spring_boot_camp.challenges.sec_20_challenge_6.contacts.exception.NoContactException;
import com.udemy.ltp.spring_boot_camp.challenges.sec_20_challenge_6.contacts.pojo.Contact;
import com.udemy.ltp.spring_boot_camp.challenges.sec_20_challenge_6.contacts.repo.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class ContactServiceImplementation implements ContactService {
	@Autowired
	private ContactRepository contactRepository;

	private int findIndexById(String id) throws NoContactException {
		return IntStream.range(0, contactRepository.getContacts().size())
										.filter(index -> contactRepository.getContacts().get(index).getId().equals(id))
										.findFirst()
										.orElseThrow(() -> new NoContactException());
	}

	@Override
	public List<Contact> getAllContacts() {
		return contactRepository.getContacts();
	}

	@Override
	public Contact getContactById(String id) throws NoContactException {
		return contactRepository.getContact(findIndexById(id));
	}

	@Override
	public void saveContact(Contact contact) {
		contactRepository.saveContact(contact);
	}

	@Override
	public void updateContact(String id, Contact contact) throws NoContactException {
		contactRepository.updateContact(findIndexById(id), contact);
	}

	@Override
	public void deleteContact(String id) throws NoContactException {
		contactRepository.deleteContact(findIndexById(id));
	}

	@Override
	public void deleteAllContacts() {
		contactRepository.deleteContacts();
	}
}
