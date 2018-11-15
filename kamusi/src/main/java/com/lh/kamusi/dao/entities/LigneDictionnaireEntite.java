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

import com.lh.kamusi.dao.entities.pk.DictionnairePk;


@Entity
@Table(name="Dictionnaire")
public class LigneDictionnaireEntite implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 7494809426312276556L;

	@EmbeddedId
	private DictionnairePk dictionnairePk; 
	
	@Column(name="mot_ang")
    private String motAng;

    @Column(name = "mot_ndz")
    private String motNdz;

    @Column(name = "mot_mwa")
    private String motMwa;

    @Column(name = "mot_mao")
    private String motMao;
    
    @Column(name="suggestion")
    private String suggestion; 
    
    @Column(name="definition_fr")
    private String definitionFr; 
    
    @Column(name="definition_com")
    private String definitionCom; 
    
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_utilisateur", nullable = false)
    private UtilisateurEntite utilisateur;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_statut")
    private StatutEntite statut;

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
	 * @return the mot_ndz
	 */
	public String getMotNdz() {
		return motNdz;
	}

	/**
	 * @param mot_ndz the mot_ndz to set
	 */
	public void setMotNdz(String motNdz) {
		this.motNdz = motNdz;
	}

	/**
	 * @return the mot_mwa
	 */
	public String getMotMwa() {
		return motMwa;
	}

	/**
	 * @param mot_mwa the mot_mwa to set
	 */
	public void setMotMwa(String motMwa) {
		this.motMwa = motMwa;
	}

	/**
	 * @return the mot_mao
	 */
	public String getMotMao() {
		return motMao;
	}

	/**
	 * @param motMao the mot_mao to set
	 */
	public void setMotMao(String motMao) {
		this.motMao = motMao;
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
	public DictionnairePk getDictionnairePk() {
		return dictionnairePk;
	}

	/**
	 * @param dictionnairePk the dictionnairePk to set
	 */
	public void setDictionnairePk(DictionnairePk dictionnairePk) {
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
	public String getDefinitionFr() {
		return definitionFr;
	}

	/**
	 * @param definition_fr the definition_fr to set
	 */
	public void setDefinitionFr(String definitionFr) {
		this.definitionFr = definitionFr;
	}

	/**
	 * @return the definition_com
	 */
	public String getDefinitionCom() {
		return definitionCom;
	}

	/**
	 * @param definition_com the definition_com to set
	 */
	public void setDefinitionCom(String definitionCom) {
		this.definitionCom = definitionCom;
	}

	
}
