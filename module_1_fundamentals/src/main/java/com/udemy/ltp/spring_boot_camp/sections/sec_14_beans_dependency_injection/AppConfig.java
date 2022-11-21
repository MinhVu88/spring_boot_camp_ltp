// any class that's annotated as @Configuration is responsible for registering beans by using @Bean
package com.udemy.ltp.spring_boot_camp.sections.sec_14_beans_dependency_injection;

import com.udemy.ltp.spring_boot_camp.sections.sec_14_beans_dependency_injection.repository.GradeRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public GradeRepo gradeRepo() {
		return new GradeRepo();
	}
}
