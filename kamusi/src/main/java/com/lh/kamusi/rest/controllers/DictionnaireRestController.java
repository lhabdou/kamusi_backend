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

import com.lh.kamusi.metier.domain.LigneDictionnaireForm;
import com.lh.kamusi.metier.services.IDictionnaireService;

@RestController
@RequestMapping(value = "/kamusi", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DictionnaireRestController {
	
	/**
	 * le service dictionnaireService
	 */
	@Autowired
	private IDictionnaireService dictionnaireServices;
	
	
	/**
	 * lister les mots en français
	 * 
	 * @param motCle
	 * @return ResponseEntity<List<LigneDictionnaire>>
	 */
	@RequestMapping(value = "/rechercher/{motCle}", method = RequestMethod.GET)
	public ResponseEntity<List<LigneDictionnaireForm>> listerLesMotsFr(@PathVariable("motCle") String motCle) {
		
		return new ResponseEntity<>(dictionnaireServices.listerLesmotsFr(motCle), HttpStatus.OK); 
		
	}
	
	
}
