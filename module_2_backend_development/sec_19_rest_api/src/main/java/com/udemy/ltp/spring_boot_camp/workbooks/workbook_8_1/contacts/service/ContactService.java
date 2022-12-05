package com.udemy.ltp.spring_boot_camp.workbooks.workbook_8_1.contacts.service;

import com.udemy.ltp.spring_boot_camp.contacts.pojo.Contact;
import com.udemy.ltp.spring_boot_camp.workbooks.workbook_8_1.contacts.exception.NoContactException;
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
