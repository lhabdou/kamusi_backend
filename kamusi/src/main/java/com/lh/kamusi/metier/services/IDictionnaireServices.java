package com.lh.kamusi.metier.services;

import java.util.List;

import com.lh.kamusi.metier.domain.LigneDictionnaireForm;

/**
 * @author asoilihi
 *
 */
public interface IDictionnaireServices {
	
	/**
	 * @param motCle
	 * @return List<LigneDictionnaire>
	 */
	List<LigneDictionnaireForm> listerLesmotsFr(String motCle); 
	
	/**
	 * @param ligneDictionnaire
	 * @return LigneDictionnaire
	 */
	LigneDictionnaireForm ajouterUneLigneDictionnaire(LigneDictionnaireForm ligneDictionnaire); 
	
	/**
	 * @param ligneDictionnaire
	 * @return LigneDictionnaire
	 */
	LigneDictionnaireForm validerUneLigneDictionnaire(LigneDictionnaireForm ligneDictionnaire); 
	
	/**
	 * @param ligneDictionnaire
	 */
	void supprimerUneLigneDictionnaire(LigneDictionnaireForm ligneDictionnaire); 
	
	/**
	 * @param ligneDictionnaire
	 */
	void modifierUneLigneDictionnaire(LigneDictionnaireForm ligneDictionnaire); 
	

}
