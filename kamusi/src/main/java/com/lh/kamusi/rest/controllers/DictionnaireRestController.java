package com.lh.kamusi.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.firebase.auth.FirebaseAuthException;
import com.lh.kamusi.metier.domain.LigneDictionnaireForm;
import com.lh.kamusi.metier.services.IDictionnaireService;
import com.lh.kamusi.rest.firebase.FirebaseVerification;

@RestController
@CrossOrigin("http://localhost:8100")
@RequestMapping(value = "/kamusi", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DictionnaireRestController {

	/**
	 * le service dictionnaireService
	 */
	@Autowired
	private IDictionnaireService dictionnaireServices;
	@Autowired
	private FirebaseVerification firebaseVerification;

	/**
	 * lister les mots en français
	 * 
	 * @param motCle
	 * @return ResponseEntity<List<LigneDictionnaire>>
	 */
	@RequestMapping(value = "/rechercher/{motCle}", method = RequestMethod.GET)
	public ResponseEntity<List<LigneDictionnaireForm>> listerLesMotsFr(@PathVariable("motCle") String motCle,
			@RequestHeader(value = "langue") String langue) {

		return new ResponseEntity<>(dictionnaireServices.listerLesMots(motCle, langue), HttpStatus.OK);

	}

	/**
	 * @param ligneDictionnaireForm
	 * @return ResponseEntity<LigneDictionnaireForm>
	 * @throws FirebaseAuthException 
	 */
	@RequestMapping(value = "/valider", method = RequestMethod.PUT)
	public ResponseEntity<LigneDictionnaireForm> modifierLigneDictionnaire(
			@RequestBody LigneDictionnaireForm ligneDictionnaireForm, @RequestHeader("token") String token) throws FirebaseAuthException {
		String uid = firebaseVerification.getUserIdFromIdToken(token);
		return new ResponseEntity<>(dictionnaireServices.modifierUneLigneDictionnaire(ligneDictionnaireForm, uid),
				HttpStatus.OK);
	}

	/**
	 * @param ligneDictionnaireForm
	 * @return ResponseEntity<LigneDictionnaireForm>
	 * @throws FirebaseAuthException
	 */
	@RequestMapping(value = "/proposermodification", method = RequestMethod.PUT)
	public ResponseEntity<LigneDictionnaireForm> proposerModification(
			@RequestBody LigneDictionnaireForm ligneDictionnaireForm, @RequestHeader("token") String token)
			throws FirebaseAuthException {

		String uid = firebaseVerification.getUserIdFromIdToken(token);
		return new ResponseEntity<>(dictionnaireServices.modifierUneLigneDictionnaire(ligneDictionnaireForm, uid),
				HttpStatus.OK);
	}

}
