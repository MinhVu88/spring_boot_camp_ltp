package com.udemy.ltp.spring_boot_camp.basic_auth.contacts.service;

import java.util.List;

import com.udemy.ltp.spring_boot_camp.basic_auth.contacts.pojo.Contact;

public interface ContactService {
	Contact getContactById(String id);
	void saveContact(Contact contact);
	List<Contact> getContacts();
	void deleteContact(String id);
}
