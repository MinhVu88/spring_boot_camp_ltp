package com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByUsername(String username);
}