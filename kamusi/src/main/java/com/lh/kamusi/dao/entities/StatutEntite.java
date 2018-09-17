package com.lh.kamusi.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Statut")
public class StatutEntite implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9187279696761858059L;

	@Id
	@GeneratedValue
    private Integer id_statut;
	
	@Column(name="statut")
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
