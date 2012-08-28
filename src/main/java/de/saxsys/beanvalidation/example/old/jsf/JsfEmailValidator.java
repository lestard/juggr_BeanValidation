package de.saxsys.beanvalidation.example.old.jsf;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("de.saxsys.EmailValidator")
public class JsfEmailValidator implements Validator {

	private static final String PATTERN = "\\b[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b";

	private final Pattern pattern;

	public JsfEmailValidator() {
		pattern = Pattern.compile(PATTERN);
	}


	@Override
	public void validate(final FacesContext ctx, final UIComponent component, final Object value)
			throws ValidatorException {

		final Matcher matcher = pattern.matcher(value.toString());

		if (!matcher.matches()) {

			final FacesMessage message = new FacesMessage("Email-Address validation failed");

			message.setSeverity(FacesMessage.SEVERITY_ERROR);

			throw new ValidatorException(message);
		}
	}

}
