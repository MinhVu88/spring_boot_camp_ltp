package com.udemy.ltp.spring_boot_camp.sections.sec_14_beans_dependency_injection.annotation;

import com.udemy.ltp.spring_boot_camp.sections.sec_14_beans_dependency_injection.ScoreValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ScoreValidator.class)
public @interface Score {
	String message() default "invalid data";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
