package com.lh.kamusi.metier.services;

import java.util.List;

import com.lh.kamusi.metier.domain.UtilisateurForm;

public interface IUtilisateurService {
	
	
	/**
	 * @param role
	 * @return List<UtilisateurForm>
	 */
	List<UtilisateurForm> listerLesUtilisateurs(String role); 
	
	/**
	 * @param utilisateurForm
	 * @return UtilisateurForm
	 */
	UtilisateurForm ajouterUtilisateur(UtilisateurForm utilisateurForm); 
	
	/**
	 * @param utilisateurForm
	 */
	void supprimerUtilisateur(UtilisateurForm utilisateurForm);

	/**
	 * @return List<UtilisateurForm>
	 */
	List<UtilisateurForm> tousListerLesUtilisateurs();

	/**
	 * @param uid
	 * @return UtilisateurForm
	 */
	UtilisateurForm getProfileUtilisateur(String uid); 
	
	

}
