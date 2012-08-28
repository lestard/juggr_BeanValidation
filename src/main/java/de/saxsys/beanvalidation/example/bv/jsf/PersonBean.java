package de.saxsys.beanvalidation.example.bv.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import de.saxsys.beanvalidation.example.bv.PersonNew;

@Named("personBeanNeu")
@RequestScoped
public class PersonBean {

	private PersonNew person;

	public PersonBean() {
		person = new PersonNew("", "", 0);
	}

	public PersonNew getPerson() {
		return person;
	}

	public void setPerson(final PersonNew person) {
		this.person = person;
	}

	public void save() {
		System.out.println("Save");
	}

}
