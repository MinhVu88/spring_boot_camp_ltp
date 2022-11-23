package com.udemy.ltp.spring_boot_camp.sections.sec_14_beans_dependency_injection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
	"com.udemy.ltp.spring_boot_camp.sections.sec_14_beans_dependency_injection.controller",
	"com.udemy.ltp.spring_boot_camp.sections.sec_14_beans_dependency_injection.service",
	"com.udemy.ltp.spring_boot_camp.sections.sec_14_beans_dependency_injection.repository"
})
public class GradeSubmissionApp {
	public static void main(String[] args) {
		SpringApplication.run(GradeSubmissionApp.class, args);
	}
}
