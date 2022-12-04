package com.udemy.ltp.spring_boot_camp.contacts.service;

import com.udemy.ltp.spring_boot_camp.contacts.pojo.Contact;

public interface ContactService {
    Contact getContactById(String id);
}
