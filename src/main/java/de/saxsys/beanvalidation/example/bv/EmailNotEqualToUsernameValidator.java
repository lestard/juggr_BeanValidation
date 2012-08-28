package de.saxsys.beanvalidation.example.bv;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailNotEqualToUsernameValidator implements ConstraintValidator<EmailNotEqualToUsername, PersonNew> {

	@Override
	public void initialize(final EmailNotEqualToUsername constraintAnnotation) {

	}

	@Override
	public boolean isValid(final PersonNew value, final ConstraintValidatorContext context) {

		final String emailAddress = value.getEmailAddress();

		final String username = value.getUsername();

		if (emailAddress != null) {
			return !emailAddress.equals(username);
		} else {
			return false;
		}
	}

}
