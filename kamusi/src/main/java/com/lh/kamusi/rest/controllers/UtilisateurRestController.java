package com.lh.kamusi.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
	 * lister les mots en français
	 * 
	 * @param motCle
	 * @return ResponseEntity<List<LigneDictionnaire>>
	 */
	@RequestMapping(value = "/utilisateurs/{role}", method = RequestMethod.GET)
	public ResponseEntity<List<UtilisateurForm>> listerLesUtilisateursRole(@PathVariable("role") String role) {
		
		return new ResponseEntity<>(utilisateurService.listerLesUtilisateurs(role), HttpStatus.OK); 
		
	}

}