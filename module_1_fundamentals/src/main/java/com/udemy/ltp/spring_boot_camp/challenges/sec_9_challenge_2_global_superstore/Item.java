package com.udemy.ltp.spring_boot_camp.challenges.sec_9_challenge_2_global_superstore;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

public class Item {
	private String id;
	private String category;
	private String name;
	private double price;
	private double discount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	public Item() {
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
