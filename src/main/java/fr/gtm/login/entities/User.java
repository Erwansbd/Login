package fr.gtm.login.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@NamedQueries({
	@NamedQuery(name = "Login", query = "SELECT u FROM Utilisateur u WHERE u.nom = :nom AND u.motDePass = :motDePass")
})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column(name = "user")
	private String nom;
	@Column(name = "password")
	private String password;
	@Column(name = "role")
	private String role;

	public User() {
		
	}

	public User(String nom, String password) {
		this.nom = nom;
		this.password = password;
	}

	
	
	public User(String id, String nom, String role) {
		this.id = id;
		this.nom = nom;
		this.role = role;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", role=" + role + "]";
	}

	
	
}
