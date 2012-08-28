package de.saxsys.beanvalidation.example.old;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import de.saxsys.beanvalidation.example.AbstractEntity;

@Entity
@Table(name = "PERSON")
public class Person extends AbstractEntity {


	@Column(nullable = false)
	private String emailAddress;

	@Column(nullable = false)
	private String username;


	private int schuhgröße;

	public Person(final String emailAddress, final String username, final int schuhgröße) {
		this.emailAddress = emailAddress;
		this.username = username;
		this.schuhgröße = schuhgröße;
	}

	protected Person() {
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
