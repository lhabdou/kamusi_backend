package com.lh.kamusi.dao.entities.pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DictionnairePk implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4418241231122267901L;

	@Column(name="mot_fr")
	private String motFr;
	
	@Column(name="mot_ngz")
    private String motNgz;

	/**
	 * @return the mot_fr
	 */
	public String getMotFr() {
		return motFr;
	}

	/**
	 * @param mot_fr the mot_fr to set
	 */
	public void setMotFr(String motFr) {
		this.motFr = motFr;
	}

	/**
	 * @return the motNgz
	 */
	public String getMotNgz() {
		return motNgz;
	}

	/**
	 * @param motNgz the motNgz to set
	 */
	public void setMotNgz(String motNgz) {
		this.motNgz = motNgz;
	}

	

}
