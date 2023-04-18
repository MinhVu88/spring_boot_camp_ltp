package com.udemy.ltp.spring_boot_camp.basic_auth.contacts.exception;

public class ContactNotFoundException extends RuntimeException {
	public ContactNotFoundException(String id) {
		super("The id '" + id + "' does not exist in our records");
	}
}
