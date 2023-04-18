package com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.security.manager;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.entity.User;
import com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.service.UserServiceImpl;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {
  private BCryptPasswordEncoder bCryptPasswordEncoder;
  private UserServiceImpl userServiceImpl;

	@Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String validUsername = authentication.getName();
    
    User user = userServiceImpl.getUser(validUsername);
    
    String hashedUserPasswordFromDb = user.getPassword();
    String hashedUserPasswordFromClient = authentication.getCredentials().toString();

    if(!bCryptPasswordEncoder.matches(hashedUserPasswordFromClient, hashedUserPasswordFromDb)) {
      throw new BadCredentialsException("invalid credentials");
    }

    Authentication authenticatedCredentials = new UsernamePasswordAuthenticationToken(validUsername, hashedUserPasswordFromClient);

    return authenticatedCredentials;
  }
}
