package com.lh.kamusi.dao.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@Column(name="id_utilisateur", nullable=false)
	private String idUtilisateur;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "pseudo")
	private String pseudo;
	
	@Column(name = "tel")
	private String tel;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "pays")
	private PaysEntite pays;
	
	@Column(name = "google_connect")
	private boolean googleConnect;

	@Column(name = "url_image")
	private String urlImage;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_role")
	private RoleEntite role;

	/**
	 * @return the id_utilisateur
	 */
	public String getIdUtilisateur() {
		return idUtilisateur;
	}

	/**
	 * @param id_utilisateur the id_utilisateur to set
	 */
	public void setIdUtilisateur(String idUtilisateur) {
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
	public RoleEntite getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(RoleEntite role) {
		this.role = role;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the googleConnect
	 */
	public boolean isGoogleConnect() {
		return googleConnect;
	}

	/**
	 * @param googleConnect the googleConnect to set
	 */
	public void setGoogleConnect(boolean googleConnect) {
		this.googleConnect = googleConnect;
	}

	/**
	 * @return the pays
	 */
	public PaysEntite getPays() {
		return pays;
	}

	/**
	 * @param pays the pays to set
	 */
	public void setPays(PaysEntite pays) {
		this.pays = pays;
	}
	
	

}
