package com.udemy.ltp.spring_boot_camp.contacts.service;

import com.udemy.ltp.spring_boot_camp.contacts.pojo.Contact;

import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts();
    Contact getContactById(String id);
    void saveContact(Contact contact);
    void updateContact(String id, Contact contact);
    void deleteContact(String id);
    void deleteAllContacts();
}
