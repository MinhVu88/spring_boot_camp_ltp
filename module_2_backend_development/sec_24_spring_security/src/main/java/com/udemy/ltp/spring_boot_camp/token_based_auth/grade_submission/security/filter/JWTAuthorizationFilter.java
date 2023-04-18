package com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.security.filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.security.SecurityConstants;

public class JWTAuthorizationFilter extends OncePerRequestFilter {
	@Override
  protected void doFilterInternal(
    HttpServletRequest request, 
    HttpServletResponse response, 
    FilterChain filterChain
  ) throws ServletException, IOException {
    // with token-based auth -> Authorization : Bearer JWT Token
    String requestHeader = request.getHeader("Authorization");

    if(requestHeader == null || !requestHeader.startsWith(SecurityConstants.BEARER)) {
      filterChain.doFilter(request, response);
    } else {
      String jwtToken = requestHeader.replace(SecurityConstants.BEARER, "");

      String username = JWT.require(Algorithm.HMAC512(SecurityConstants.SECRET_KEY))
                           .build()
                           .verify(jwtToken)
                           .getSubject();

      // WRONG CONSTRUCTOR                     
      // Authentication authentication = new UsernamePasswordAuthenticationToken(username, null); 
      Authentication authentication = new UsernamePasswordAuthenticationToken(username, null, Arrays.asList());

      SecurityContextHolder.getContext().setAuthentication(authentication);

      filterChain.doFilter(request, response);
    }
  }
}
