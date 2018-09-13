package com.lh.kamusi.metier.services;

import java.util.List;

import com.lh.kamusi.metier.domain.LigneDictionnaire;

/**
 * @author asoilihi
 *
 */
public interface IDictionnaireServices {
	
	/**
	 * @param motCle
	 * @return List<LigneDictionnaire>
	 */
	List<LigneDictionnaire> listerLesmotsFr(String motCle); 
	
	/**
	 * @param ligneDictionnaire
	 * @return LigneDictionnaire
	 */
	LigneDictionnaire ajouterUneLigneDictionnaire(LigneDictionnaire ligneDictionnaire); 
	
	/**
	 * @param ligneDictionnaire
	 * @return LigneDictionnaire
	 */
	LigneDictionnaire validerUneLigneDictionnaire(LigneDictionnaire ligneDictionnaire); 
	
	/**
	 * @param ligneDictionnaire
	 */
	void supprimerUneLigneDictionnaire(LigneDictionnaire ligneDictionnaire); 
	
	/**
	 * @param ligneDictionnaire
	 */
	void modifierUneLigneDictionnaire(LigneDictionnaire ligneDictionnaire); 
	

}
