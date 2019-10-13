package fr.gtm.login.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import fr.gtm.login.entities.User;

public class LoginDAO {
	private EntityManagerFactory emf;

	public LoginDAO(EntityManagerFactory emf) {
		super();
		this.emf = emf;
	}
	
	public void create(User utilisateur) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(utilisateur);

		em.getTransaction().commit();
		em.close();
	}
	
	public User getUtilisateurByNom(String nom) {
		EntityManager em = emf.createEntityManager();
		User utilisateur = em.find(User.class, nom);
		em.close();
		return utilisateur;
	}

	
	public User testConnexion(String nom,String password) {
		EntityManager em = emf.createEntityManager();
		User u = em.createNamedQuery("Login", User.class).setParameter("nom", nom).setParameter("password", password).getSingleResult();

		return u;
		
	}

}
