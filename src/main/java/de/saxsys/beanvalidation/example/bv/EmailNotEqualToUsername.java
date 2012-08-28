package de.saxsys.beanvalidation.example.bv;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailNotEqualToUsernameValidator.class)
public @interface EmailNotEqualToUsername {
	String message() default "EmailAddress and Username should not be equal";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
