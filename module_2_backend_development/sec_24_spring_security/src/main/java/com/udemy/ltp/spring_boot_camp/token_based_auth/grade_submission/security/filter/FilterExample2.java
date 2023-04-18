package com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.entity.User;

public class FilterExample2 implements Filter {
  @Override
  public void doFilter(
    ServletRequest req, 
    ServletResponse res, 
    FilterChain chain
  ) throws IOException, ServletException {
    User user = new ObjectMapper().readValue(((HttpServletRequest) req).getInputStream(), User.class);

    System.out.println(
      "FilterExample2 -> " + "username: " + user.getUsername() + " | pass: " + user.getPassword()
    );
  }
}
