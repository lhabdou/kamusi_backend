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

	private Integer idStatut; 
	
	private String statut;

	/**
	 * @return the idStatut
	 */
	public Integer getIdStatut() {
		return idStatut;
	}

	/**
	 * @param idStatut the idStatut to set
	 */
	public void setIdStatut(Integer idStatut) {
		this.idStatut = idStatut;
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
