package com.udemy.ltp.spring_boot_camp.basic_auth.contacts.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@AllArgsConstructor
public class SecurityConfig {
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Bean
	public SecurityFilterChain filterHttpRequest(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(
									requests -> requests.antMatchers(HttpMethod.DELETE, "/contacts/delete/*").hasRole("ADMIN")
																			.antMatchers(HttpMethod.POST).hasAnyRole("ADMIN", "USER")
																			.antMatchers(HttpMethod.GET).permitAll()
																			.anyRequest().authenticated()
								)
                .httpBasic(withDefaults())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		return httpSecurity.build();
	}

	@Bean
	public UserDetailsService authenticateClientCredentials() {
		UserDetails admin = User.builder()
														.username("admin")
														.password(bCryptPasswordEncoder.encode("admin"))
														.roles("ADMIN")
														.build();

		UserDetails user = User.builder()
													 .username("user")
													 .password(bCryptPasswordEncoder.encode("user"))
													 .roles("USER")
													 .build();

		return new InMemoryUserDetailsManager(admin, user);
	}
}
