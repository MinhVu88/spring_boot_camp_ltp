package com.udemy.ltp.spring_boot_camp.challenges.sec_20_challenge_6.contacts.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI().info(
			new Info().title("Contact API")
							  .description("contact management API")
								.version("v1.0")
		);
	}
}
