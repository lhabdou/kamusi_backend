package com.lh.kamusi.dao.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.lh.kamusi.dao.entities.pk.Dictionnaire_PK;


@Entity
@Table(name="Dictionnaire_Temp")
public class DictionnaireTempEntite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2338076693242034232L;
	

	@EmbeddedId
	private Dictionnaire_PK dictionnairePk; 
	
	@Column(name="mot_ang")
    private String mot_ang;

    @Column(name = "mot_ndz")
    private String mot_ndz;

    @Column(name = "mot_mwa")
    private String mot_mwa;

    @Column(name = "mot_mao")
    private String mot_mao;
    
    @Column(name="suggestion")
    private String suggestion; 
    
    @Column(name="definition_fr")
    private String definition_fr; 
    
    @Column(name="definition_com")
    private String definition_com; 
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private UtilisateurEntite utilisateur;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_statut")
    private StatutEntite statut;

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
	 * @return the utilisateur
	 */
	public UtilisateurEntite getUtilisateur() {
		return utilisateur;
	}

	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(UtilisateurEntite utilisateur) {
		this.utilisateur = utilisateur;
	}

	/**
	 * @return the dictionnairePk
	 */
	public Dictionnaire_PK getDictionnairePk() {
		return dictionnairePk;
	}

	/**
	 * @param dictionnairePk the dictionnairePk to set
	 */
	public void setDictionnairePk(Dictionnaire_PK dictionnairePk) {
		this.dictionnairePk = dictionnairePk;
	}

	/**
	 * @return the statut
	 */
	public StatutEntite getStatut() {
		return statut;
	}

	/**
	 * @param statut the statut to set
	 */
	public void setStatut(StatutEntite statut) {
		this.statut = statut;
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

    
	
	
}
