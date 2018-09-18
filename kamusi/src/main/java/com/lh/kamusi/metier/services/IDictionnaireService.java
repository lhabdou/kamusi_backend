package com.lh.kamusi.metier.services;

import java.util.List;

import com.lh.kamusi.metier.domain.LigneDictionnaireForm;

/**
 * @author asoilihi
 *
 */
public interface IDictionnaireService {
	
	/**
	 * @param motCle
	 * @return List<LigneDictionnaire>
	 */
	List<LigneDictionnaireForm> listerLesmotsFr(String motCle); 
	
	/**
	 * @return List<LigneDictionnaire>
	 */
	List<LigneDictionnaireForm> listerLesmotsAvalider(); 
	
	/**
	 * @param ligneDictionnaire
	 * @return LigneDictionnaire
	 */
	LigneDictionnaireForm ajouterUneLigneDictionnaire(LigneDictionnaireForm ligneDictionnaire); 
	
	/**
	 * @param ligneDictionnaire
	 * @return LigneDictionnaire
	 */
	LigneDictionnaireForm validerUneLigneDictionnaire(LigneDictionnaireForm ligneDictionnaire, Boolean motComModifie); 
	
	/**
	 * @param ligneDictionnaire
	 */
	void supprimerUneLigneDictionnaire(LigneDictionnaireForm ligneDictionnaire); 
	
	/**
	 * @param ligneDictionnaire
	 */
	LigneDictionnaireForm modifierUneLigneDictionnaire(LigneDictionnaireForm ligneDictionnaire); 
	

}
