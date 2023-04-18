package com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.security.filter.AuthenticationFilter;
import com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.security.filter.ExceptionHandlerFilter;
import com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.security.filter.JWTAuthorizationFilter;
import com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.security.manager.CustomAuthenticationManager;

import lombok.AllArgsConstructor;

import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@AllArgsConstructor
public class SecurityConfig {
	private CustomAuthenticationManager customAuthenticationManager;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		AuthenticationFilter authenticationFilter = new AuthenticationFilter(customAuthenticationManager);
		authenticationFilter.setFilterProcessesUrl("/authenticate");

    http.headers(headers -> headers.frameOptions().disable())
      	.csrf(csrf -> csrf.disable())
      	.authorizeHttpRequests(
					requests -> requests.antMatchers("/h2/**").permitAll() // New Line: allows us to access the h2 console without the need to authenticate. ' ** '  instead of ' * ' because multiple path levels will follow /h2.
															.antMatchers(
																HttpMethod.POST, 
																SecurityConstants.REGISTER_PATH
															).permitAll()
															.anyRequest().authenticated()
				)
				/*.addFilterBefore(new FilterExample1(), AuthenticationFilter.class)*/
      	.addFilterBefore(new ExceptionHandlerFilter(), AuthenticationFilter.class)
				.addFilter(authenticationFilter)
				.addFilterAfter(new JWTAuthorizationFilter(), AuthenticationFilter.class)
				/*.addFilterAfter(new FilterExample2(), AuthenticationFilter.class)*/
      	.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		return http.build();
	}
}