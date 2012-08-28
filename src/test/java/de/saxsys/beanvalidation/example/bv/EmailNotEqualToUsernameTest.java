package de.saxsys.beanvalidation.example.bv;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Before;
import org.junit.Test;

public class EmailNotEqualToUsernameTest {

	private Validator validator;

	@Before
	public void setUp() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}

	@Test
	public void testEmailNotEqualToUsername() {

		final PersonNew p = new PersonNew("test@example.org", "test@example.org", 30);

		final Set<ConstraintViolation<PersonNew>> violations = validator.validate(p);

		assertThat(violations).hasSize(1);

	}

}
