package de.saxsys.beanvalidation.example.bv;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import de.saxsys.beanvalidation.example.AbstractEntity;

@Entity
@Table(name = "PERSON_NEW")
@EmailNotEqualToUsername
public class PersonNew extends AbstractEntity {

	@ValidEmail
	// @NotNull
	// @Pattern(regexp = "\\b[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}\\b")
	private String emailAddress;

	@NotNull
	@Size(min = 5, max = 30)
	private String username;

	@Min(15)
	@Max(message = "Dein Schuh ist zu groß", value = 70)
	private int schuhgröße;

	public PersonNew(final String emailAddress, final String username, final int schuhgröße) {
		this.emailAddress = emailAddress;
		this.username = username;
		this.schuhgröße = schuhgröße;
	}

	protected PersonNew() {
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(final String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public int getSchuhgröße() {
		return schuhgröße;
	}

	public void setSchuhgröße(final int schuhgröße) {
		this.schuhgröße = schuhgröße;
	}
}
