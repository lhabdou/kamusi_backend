/**
 * 
 */
package com.lh.kamusi.metier.domain;

import java.io.Serializable;

/**
 * @author asoilihi
 *
 */
public class LigneDictionnaireForm implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 449981082446983873L;

	private String mot_fr;
	
    private String mot_com;
	
	private String mot_ang;

    private String mot_ndz;

    private String mot_mwa;

    private String mot_mao;
    
    private String definition_fr; 
    
    private String definition_com;
    
    private String suggestion; 

    private UtilisateurForm utilisateur;

    private StatutForm statut;

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

	/**
	 * @return the mot_ang
	 */
	public String getMot_ang() {
		return mot_ang;
	}

	/**
	 * @param mot_ang the mot_ang to set
	 */
	public void setMot_ang(String mot_ang) {
		this.mot_ang = mot_ang;
	}

	/**
	 * @return the mot_ndz
	 */
	public String getMot_ndz() {
		return mot_ndz;
	}

	/**
	 * @param mot_ndz the mot_ndz to set
	 */
	public void setMot_ndz(String mot_ndz) {
		this.mot_ndz = mot_ndz;
	}

	/**
	 * @return the mot_mwa
	 */
	public String getMot_mwa() {
		return mot_mwa;
	}

	/**
	 * @param mot_mwa the mot_mwa to set
	 */
	public void setMot_mwa(String mot_mwa) {
		this.mot_mwa = mot_mwa;
	}

	/**
	 * @return the mot_mao
	 */
	public String getMot_mao() {
		return mot_mao;
	}

	/**
	 * @param mot_mao the mot_mao to set
	 */
	public void setMot_mao(String mot_mao) {
		this.mot_mao = mot_mao;
	}

	/**
	 * @return the definition_fr
	 */
	public String getDefinition_fr() {
		return definition_fr;
	}

	/**
	 * @param definition_fr the definition_fr to set
	 */
	public void setDefinition_fr(String definition_fr) {
		this.definition_fr = definition_fr;
	}

	/**
	 * @return the definition_com
	 */
	public String getDefinition_com() {
		return definition_com;
	}

	/**
	 * @param definition_com the definition_com to set
	 */
	public void setDefinition_com(String definition_com) {
		this.definition_com = definition_com;
	}

	/**
	 * @return the suggestion
	 */
	public String getSuggestion() {
		return suggestion;
	}

	/**
	 * @param suggestion the suggestion to set
	 */
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	/**
	 * @return the utilisateur
	 */
	public UtilisateurForm getUtilisateur() {
		return utilisateur;
	}

	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(UtilisateurForm utilisateur) {
		this.utilisateur = utilisateur;
	}

	/**
	 * @return the statut
	 */
	public StatutForm getStatut() {
		return statut;
	}

	/**
	 * @param statut the statut to set
	 */
	public void setStatut(StatutForm statut) {
		this.statut = statut;
	}
    

}
