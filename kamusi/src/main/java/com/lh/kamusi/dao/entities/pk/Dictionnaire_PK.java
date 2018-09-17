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
	
	@Column(name="mot_ngz")
    private String mot_ngz;

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

	public String getMot_ngz() {
		return mot_ngz;
	}

	public void setMot_ngz(String mot_ngz) {
		this.mot_ngz = mot_ngz;
	}

	
	

}
