package de.saxsys.beanvalidation.example.bv;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.saxsys.beanvalidation.example.AbstractEntity;

public class PersonJpaTestBV {

	private static final String TESTDB = "testdb";

	private EntityManagerFactory emf;

	@Before
	public void setUp() {
		emf = Persistence.createEntityManagerFactory(TESTDB);
	}

	@After
	public void tearDown() {
		emf.close();
	}

	@Test
	public void testValidPerson() {
		final PersonNew validPerson = new PersonNew("test@example.org", "myUsername", 30);
		persist(validPerson);
	}


	@Test(expected = ConstraintViolationException.class)
	public void testInvalidPersonNullEmailAddress() {
		final PersonNew invalid = new PersonNew(null, "myUsername", 30);

		persist(invalid);
	}

	@Test(expected = ConstraintViolationException.class)
	public void testInvalidPersonNullUsername() {
		final PersonNew invalid = new PersonNew("test@example.org", null, 30);

		persist(invalid);
	}


	private void persist(final AbstractEntity entity) {

		final EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();

		entityManager.persist(entity);

		entityManager.getTransaction().commit();
		entityManager.close();

	}

}
