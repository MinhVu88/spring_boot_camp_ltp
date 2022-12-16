package com.udemy.ltp.spring_boot_camp.challenges.sec_20_challenge_6.contacts.service;

import com.udemy.ltp.spring_boot_camp.challenges.sec_20_challenge_6.contacts.exception.NoContactException;
import com.udemy.ltp.spring_boot_camp.challenges.sec_20_challenge_6.contacts.pojo.Contact;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContactService {
    List<Contact> getAllContacts();
    Contact getContactById(String id) throws NoContactException;
    void saveContact(Contact contact);
    void updateContact(String id, Contact contact) throws NoContactException;
    void deleteContact(String id) throws NoContactException;
    void deleteAllContacts();
}
