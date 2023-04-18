package com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FilterExample1 implements Filter {
  @Override
  public void doFilter(
    ServletRequest req, 
    ServletResponse res, 
    FilterChain chain
  ) throws IOException, ServletException {
    System.out.println("FilterExample1 -> " + ((HttpServletRequest) req).getRequestURI());

    chain.doFilter(req, res);
  }
}
