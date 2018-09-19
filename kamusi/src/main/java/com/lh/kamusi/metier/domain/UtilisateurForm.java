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

	private Long idUtilisateur;

	private String nom;

	private String prenom;

	private String pseudo;

	private String email;

	private String urlImage;

	private RoleForm role;

	/**
	 * @return the id_utilisateur
	 */
	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	/**
	 * @param id_utilisateur the id_utilisateur to set
	 */
	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
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
	 * @return the urlImage
	 */
	public String getUrlImage() {
		return urlImage;
	}

	/**
	 * @param urlImage the urlImage to set
	 */
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
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
