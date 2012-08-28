package de.saxsys.beanvalidation.example.bv;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.routines.EmailValidator;

public class CustomEmailValidator implements ConstraintValidator<ValidEmail, String> {

	@Override
	public void initialize(final ValidEmail constraintAnnotation) {
	}

	@Override
	public boolean isValid(final String value, final ConstraintValidatorContext context) {

		final EmailValidator validator = EmailValidator.getInstance();

		return validator.isValid(value);
	}

}
