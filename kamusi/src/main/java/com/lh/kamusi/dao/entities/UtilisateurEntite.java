package com.lh.kamusi.dao.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Utilisateur")
public class UtilisateurEntite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7966650235494300375L;

	@Id
	@GeneratedValue
	private Long id_utilisateur;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "pseudo")
	private String pseudo;

	@Column(name = "email")
	private String email;

	@Column(name = "url_image")
	private String url_image;

	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "id_role")
	private RoleEntite role;

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
	public RoleEntite getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(RoleEntite role) {
		this.role = role;
	}
	
	

}
