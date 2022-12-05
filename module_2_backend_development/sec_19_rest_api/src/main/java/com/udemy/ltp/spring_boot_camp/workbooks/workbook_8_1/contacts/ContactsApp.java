package com.udemy.ltp.spring_boot_camp.workbooks.workbook_8_1.contacts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
	"com.udemy.ltp.spring_boot_camp.workbooks.workbook_8_1.contacts.service",
	"com.udemy.ltp.spring_boot_camp.workbooks.workbook_8_1.contacts.repo",
	"com.udemy.ltp.spring_boot_camp.workbooks.workbook_8_1.contacts.web"
})
public class ContactsApp {
	public static void main(String[] args) {
		SpringApplication.run(ContactsApp.class, args);
	}
}