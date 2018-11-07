/**
 * 
 */
package com.lh.kamusi.metier.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author asoilihi
 *
 */
public class LigneDictionnaireForm implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 449981082446983873L;

	private String motFr;
	
    private String motNgz;
	
	private String motAng;

    private String motNdz;

    private String motMwa;

    private String motMao;
    
    private String definitionFr; 
    
    private String definitionCom;
    
    private String suggestion; 
    
    private String dialectModifie;

    private UtilisateurForm utilisateur;

    private StatutForm statut;
    
    
    private Date dateModification;
    
    private Date dateCreation;

	/**
	 * @return the mot_fr
	 */
	public String getMotFr() {
		return motFr;
	}

	/**
	 * @param motFr the mot_fr to set
	 */
	public void setMotFr(String motFr) {
		this.motFr = motFr;
	}



	public String getMotNgz() {
		return motNgz;
	}

	public void setMotNgz(String motNgz) {
		this.motNgz = motNgz;
	}

	/**
	 * @return the mot_ang
	 */
	public String getMotAng() {
		return motAng;
	}

	/**
	 * @param mot_ang the mot_ang to set
	 */
	public void setMotAng(String motAng) {
		this.motAng = motAng;
	}

	/**
	 * @return the motNdz
	 */
	public String getMotNdz() {
		return motNdz;
	}

	/**
	 * @param motNdz the motNdz to set
	 */
	public void setMotNdz(String motNdz) {
		this.motNdz = motNdz;
	}

	/**
	 * @return the dialectModifie
	 */
	public String getDialectModifie() {
		return dialectModifie;
	}

	/**
	 * @param dialectModifie the dialectModifie to set
	 */
	public void setDialectModifie(String dialectModifie) {
		this.dialectModifie = dialectModifie;
	}

	/**
	 * @return the motMwa
	 */
	public String getMotMwa() {
		return motMwa;
	}

	/**
	 * @param motMwa the motMwa to set
	 */
	public void setMotMwa(String motMwa) {
		this.motMwa = motMwa;
	}

	/**
	 * @return the motMao
	 */
	public String getMotMao() {
		return motMao;
	}

	/**
	 * @param motMao the motMao to set
	 */
	public void setMotMao(String motMao) {
		this.motMao = motMao;
	}

	/**
	 * @return the definitionFr
	 */
	public String getDefinitionFr() {
		return definitionFr;
	}

	/**
	 * @param definitionFr the definitionFr to set
	 */
	public void setDefinitionFr(String definitionFr) {
		this.definitionFr = definitionFr;
	}

	/**
	 * @return the definitionCom
	 */
	public String getDefinitionCom() {
		return definitionCom;
	}

	/**
	 * @param definitionCom the definitionCom to set
	 */
	public void setDefinitionCom(String definitionCom) {
		this.definitionCom = definitionCom;
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

	/**
	 * @return the dateModification
	 */
	public Date getDateModification() {
		return dateModification;
	}

	/**
	 * @param dateModification the dateModification to set
	 */
	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

	/**
	 * @return the dateCreation
	 */
	public Date getDateCreation() {
		return dateCreation;
	}

	/**
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	
	
}
