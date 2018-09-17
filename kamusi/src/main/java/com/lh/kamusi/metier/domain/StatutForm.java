/**
 * 
 */
package com.lh.kamusi.metier.domain;

import java.io.Serializable;

/**
 * @author asoilihi
 *
 */
public class StatutForm implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4242992104693138160L;

	private Integer id_statut; 
	
	private String statut;

	/**
	 * @return the id_statut
	 */
	public Integer getId_statut() {
		return id_statut;
	}

	/**
	 * @param id_statut the id_statut to set
	 */
	public void setId_statut(Integer id_statut) {
		this.id_statut = id_statut;
	}

	/**
	 * @return the statut
	 */
	public String getStatut() {
		return statut;
	}

	/**
	 * @param statut the statut to set
	 */
	public void setStatut(String statut) {
		this.statut = statut;
	}


}
