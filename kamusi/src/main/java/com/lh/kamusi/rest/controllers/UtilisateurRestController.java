package com.lh.kamusi.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lh.kamusi.metier.domain.UtilisateurForm;
import com.lh.kamusi.metier.services.IUtilisateurService;

@RestController
@RequestMapping(value = "/kamusi", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UtilisateurRestController {
	
	
	/**
	 * le service 
	 */
	@Autowired
	private IUtilisateurService utilisateurService;
	
	
	
	/**
	 * Lister tous les utilisateurs 
	 * 
	 * @return ResponseEntity<List<UtilisateurForm>>
	 */
	@RequestMapping(value = "/utilisateurs", method = RequestMethod.GET)
	public ResponseEntity<List<UtilisateurForm>> listerTousLesUtilisateurs() {
		
		return new ResponseEntity<>(utilisateurService.tousListerLesUtilisateurs(), HttpStatus.OK); 
		
	}
	
	
	/**
	 * Lister les utilisateurs ayant le role
	 * 
	 * @param role
	 * @return ResponseEntity<List<UtilisateurForm>>
	 */
	@RequestMapping(value = "/utilisateurs/{role}", method = RequestMethod.GET)
	public ResponseEntity<List<UtilisateurForm>> listerLesUtilisateursRole(@PathVariable("role") String role) {
		
		return new ResponseEntity<>(utilisateurService.listerLesUtilisateurs(role), HttpStatus.OK); 
		
	}
	
	/**
	 * Ajouter un Utilisateur 
	 * 
	 * @param utilisateurForm
	 * @return ResponseEntity<UtilisateurForm>
	 */
	@RequestMapping(value = "/utilisateurs/nouveau", method = RequestMethod.POST)
	public ResponseEntity<UtilisateurForm> ajouterUnUtilisateur(@RequestBody UtilisateurForm utilisateurForm) {
		
		return new ResponseEntity<>(utilisateurService.ajouterUtilisateur(utilisateurForm), HttpStatus.OK); 
		
	}
	
	/**
	 * Supprimer un utilisateur
	 * 
	 * @param utilisateurForm
	 * @return ResponseEntity<UtilisateurForm>
	 */
	@RequestMapping(value = "/utilisateurs/supprimer", method = RequestMethod.DELETE)
	public void supprimerUnUtilisateur(@RequestBody UtilisateurForm utilisateurForm) {
		
		 utilisateurService.supprimerUtilisateur(utilisateurForm);
		 
	}


}
