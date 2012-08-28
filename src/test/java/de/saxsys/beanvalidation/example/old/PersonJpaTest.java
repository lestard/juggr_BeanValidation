package de.saxsys.beanvalidation.example.old;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.saxsys.beanvalidation.example.AbstractEntity;


public class PersonJpaTest {

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
		final Person validPerson = new Person("test@example.org", "myUsername", 30);

		persist(validPerson);

	}


	@Test(expected = RollbackException.class)
	public void testInvalidPersonNullEmailAddress() {
		final Person invalid = new Person(null, "myUsername", 30);

		persist(invalid);
	}

	@Test(expected = RollbackException.class)
	public void testInvalidPersonNullUsername() {
		final Person invalid = new Person("test@example.org", null, 30);

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
