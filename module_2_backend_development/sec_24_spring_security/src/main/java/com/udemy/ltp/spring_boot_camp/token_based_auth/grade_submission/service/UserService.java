package com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.service;

import com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.entity.User;

public interface UserService {
	User getUser(Long id);
	User getUser(String username);
	User saveUser(User user);
}