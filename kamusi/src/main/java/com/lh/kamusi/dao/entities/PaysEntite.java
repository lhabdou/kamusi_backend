package com.lh.kamusi.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pays")
public class PaysEntite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3038246854807651282L;

	@Id
	@Column(name = "code")
	private String code;

	@Column(name = "nom")
	private String nom;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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

}
