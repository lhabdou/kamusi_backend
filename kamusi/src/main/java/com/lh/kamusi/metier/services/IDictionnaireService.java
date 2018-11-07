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
	 * @param langue 
	 * @return List<LigneDictionnaire>
	 */
	List<LigneDictionnaireForm> listerLesMots(String motCle, String langue); 
	
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
	 * @param uid 
	 */
	LigneDictionnaireForm modifierUneLigneDictionnaire(LigneDictionnaireForm ligneDictionnaire, String uid); 
	

}
