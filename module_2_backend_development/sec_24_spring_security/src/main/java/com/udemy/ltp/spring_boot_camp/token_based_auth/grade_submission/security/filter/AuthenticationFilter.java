package com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.security.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.entity.User;
import com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.security.SecurityConstants;
import com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.security.manager.CustomAuthenticationManager;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private CustomAuthenticationManager authenticationManager;	
	
	@Override
	public Authentication attemptAuthentication(
		HttpServletRequest request, 
		HttpServletResponse response
	) throws AuthenticationException {
		// the deserialization process: map the incoming http request's data to the User object's properties (username & password)
		try {
			User user = new ObjectMapper().readValue(request.getInputStream(), User.class);

			String usernameFromClient = user.getUsername();
			String passwordFromClient = user.getPassword();

			Authentication authentication = new UsernamePasswordAuthenticationToken(usernameFromClient, passwordFromClient);

			return authenticationManager.authenticate(authentication);
		} catch(IOException e) {
			throw new RuntimeException();
		}
	}

	@Override
	protected void successfulAuthentication(
		HttpServletRequest request, 
		HttpServletResponse response, 
		FilterChain chain,
		Authentication authResult
	) throws IOException, ServletException {
		String jwtToken = JWT.create()
												 .withSubject(authResult.getName())
												 .withExpiresAt(new Date(
														System.currentTimeMillis() + SecurityConstants.TOKEN_EXPIRATION
												 ))
												 .sign(Algorithm.HMAC512(SecurityConstants.SECRET_KEY));

		// with basic auth -> Authorization : Basic Username:Password
		// with token-based auth -> Authorization : Bearer JWT Token										 
		response.addHeader(SecurityConstants.AUTHORIZATION, SecurityConstants.BEARER + jwtToken);
	}

	@Override
	protected void unsuccessfulAuthentication(
		HttpServletRequest request, 
		HttpServletResponse response,
		AuthenticationException failed
	) throws IOException, ServletException {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().write(failed.getMessage());
			response.getWriter().flush();
	}

	/*
	@Override
	public void doFilter(
		ServletRequest request, 
		ServletResponse response, 
		FilterChain chain
	) throws IOException, ServletException {
		chain.doFilter(request, response);
	}
	*/
}
