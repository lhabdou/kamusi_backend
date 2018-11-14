package com.lh.kamusi.metier.services;

import java.nio.file.AccessDeniedException;
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

	/**
	 * @param dialect
	 * @param uid
	 * @return
	 * @throws AccessDeniedException 
	 */
	List<LigneDictionnaireForm> listerLesMotsAValider(String dialect, String uid) throws AccessDeniedException; 
	

}
