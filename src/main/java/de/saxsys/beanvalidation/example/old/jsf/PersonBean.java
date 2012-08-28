package de.saxsys.beanvalidation.example.old.jsf;

import javax.enterprise.inject.Model;

@Model
public class PersonBean {

	private String emailAddress;

	private int schuhgroesse;

	public void save() {
		System.out.println("Save");
	}


	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(final String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public int getSchuhgroesse() {
		return schuhgroesse;
	}

	public void setSchuhgroesse(final int schuhgroesse) {
		this.schuhgroesse = schuhgroesse;
	}



}
