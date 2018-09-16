/**
 * 
 */
package com.lh.kamusi.metier.domain;

import java.io.Serializable;

/**
 * @author asoilihi
 *
 */
public class UtilisateurForm implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4084592835867732823L;

	private Long id_utilisateur;

	private String nom;

	private String prenom;

	private String pseudo;

	private String email;

	private String url_image;

	private RoleForm role;

	/**
	 * @return the id_utilisateur
	 */
	public Long getId_utilisateur() {
		return id_utilisateur;
	}

	/**
	 * @param id_utilisateur the id_utilisateur to set
	 */
	public void setId_utilisateur(Long id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the url_image
	 */
	public String getUrl_image() {
		return url_image;
	}

	/**
	 * @param url_image the url_image to set
	 */
	public void setUrl_image(String url_image) {
		this.url_image = url_image;
	}

	/**
	 * @return the role
	 */
	public RoleForm getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(RoleForm role) {
		this.role = role;
	}

	
	
}
