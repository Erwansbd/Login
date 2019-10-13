package fr.gtm.login.dao;

import static org.junit.Assert.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;

import fr.gtm.login.entities.User;


public class TestLoginDAO {
	
	@Test
	public void testTestConnexion2() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("login");
		LoginDAO dao = new LoginDAO(emf);
		
		assertEquals(dao.testConnexion("batman", "batmanpw"), new User("2", "batman", "batmanpw"));
		
		emf.close();
	}

}
