package de.saxsys.beanvalidation.example.bv;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.junit.Before;
import org.junit.Test;

public class BeanValidationTest {


	private List<String> validEmailAddresses;
	private List<String> invalidEmailAddresses;

	private Validator validator;

	@Before
	public void setUp() {
		validEmailAddresses = new ArrayList<String>();
		validEmailAddresses.add("niceandsimple@example.com");
		validEmailAddresses.add("very.common@example.com");
		validEmailAddresses.add("a.little.lenghty.but.fine@dept.example.com");
		validEmailAddresses.add("disposable.style.email.with+symbol@example.com");


		invalidEmailAddresses = new ArrayList<String>();
		invalidEmailAddresses.add("Abc.example.com");
		invalidEmailAddresses.add("A@b@c@example.com");
		invalidEmailAddresses.add("Abc.@example.com");
		invalidEmailAddresses.add("Abc..123@example.com");


		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}


	@Test
	public void testEmailAddress() {

		final PersonNew p = new PersonNew(null, "myUsername", 30);
		Set<ConstraintViolation<PersonNew>> violations = validator.validate(p);

		// Both the @ValidEmail constraint on field-level and the @EmailNotEqualToUsername
		// constraint on class-level are violated
		assertThat(violations).hasSize(2);


		for (final String emailAddress : validEmailAddresses) {
			p.setEmailAddress(emailAddress);

			violations = validator.validate(p);

			assertThat(violations).as(emailAddress + " is valid").hasSize(0);
		}

		for (final String emailAddress : invalidEmailAddresses) {
			p.setEmailAddress(emailAddress);

			violations = validator.validate(p);

			assertThat(violations).as(emailAddress + " is invalid").hasSize(1);

			final ConstraintViolation<PersonNew> violation = violations.iterator().next();

			assertThat(violation.getInvalidValue()).isEqualTo(emailAddress);
		}
	}

	@Test
	public void testUsername() {
		final PersonNew p = new PersonNew("test@example.com", null, 30);

		Set<ConstraintViolation<PersonNew>> violations = validator.validate(p);

		assertThat(violations).hasSize(1);


		p.setUsername("kurz");

		violations = validator.validate(p);
		assertThat(violations).hasSize(1);


		p.setUsername("vielZuLangerNutzernameMitMehrAlsDreißigZeichen");

		violations = validator.validate(p);
		assertThat(violations).hasSize(1);
	}


	@Test
	public void testSchuhgröße() {
		final PersonNew p = new PersonNew("test@example.com", "myUsername", 10);

		Set<ConstraintViolation<PersonNew>> violations = validator.validate(p);

		assertThat(violations).hasSize(1);

		p.setSchuhgröße(71);

		violations = validator.validate(p);
		assertThat(violations).hasSize(1);
	}
}
