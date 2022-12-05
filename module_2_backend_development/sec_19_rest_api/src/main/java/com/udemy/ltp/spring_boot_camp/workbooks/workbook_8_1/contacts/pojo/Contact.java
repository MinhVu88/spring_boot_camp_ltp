package com.udemy.ltp.spring_boot_camp.workbooks.workbook_8_1.contacts.pojo;

import java.util.UUID;

public class Contact {
	private String id;
	private String name;
	private String phoneNumber;

	public Contact() {
		this.id = UUID.randomUUID().toString();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "id: " + id + " | name: " + name + " | phone number: " + phoneNumber;
	}
}