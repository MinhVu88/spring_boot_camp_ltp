package com.udemy.ltp.spring_boot_camp.basic_auth.contacts.pojo;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class Contact {
	private String id;

	@NotBlank(message = "Name cannot be blank")
	private String name;

	@NotBlank(message = "Phone number cannot be blank")
	private String phone;

	public Contact(String id, String name, String phone) {
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public Contact(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}

	public Contact(){
		this.id = UUID.randomUUID().toString();
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
