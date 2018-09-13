package com.lh.kamusi.dao.entities.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Dictionnaire_PK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4418241231122267901L;

	@Column(name="mot_fr")
	private String mot_fr;
	
	@Column(name="mot_com")
    private String mot_com;

	/**
	 * @return the mot_fr
	 */
	public String getMot_fr() {
		return mot_fr;
	}

	/**
	 * @param mot_fr the mot_fr to set
	 */
	public void setMot_fr(String mot_fr) {
		this.mot_fr = mot_fr;
	}

	/**
	 * @return the mot_com
	 */
	public String getMot_com() {
		return mot_com;
	}

	/**
	 * @param mot_com the mot_com to set
	 */
	public void setMot_com(String mot_com) {
		this.mot_com = mot_com;
	}
	
	

}
