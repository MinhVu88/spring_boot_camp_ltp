package com.udemy.ltp.spring_boot_camp.token_based_auth.grade_submission.exception;

public class EntityNotFoundException extends RuntimeException { 
	public EntityNotFoundException(Long id, Class<?> entity) {
		super("The " + entity.getSimpleName().toLowerCase() + " with id '" + id + "' does not exist in our records");
	}
}