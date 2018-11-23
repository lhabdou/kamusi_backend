package com.lh.kamusi.rest.controllers;

import java.nio.file.AccessDeniedException;
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
	 * lister les mots en français en fonction d'un mot clé
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
	 * lister les mots en français en fonction d'un mot clé
	 * 
	 * @param motCle
	 * @return ResponseEntity<List<LigneDictionnaire>>
	 * @throws FirebaseAuthException
	 * @throws AccessDeniedException
	 */
	@RequestMapping(value = "/listerpropositions", method = RequestMethod.GET)
	public ResponseEntity<List<LigneDictionnaireForm>> listerLesMotsAValider(
			@RequestHeader(value = "dialect") String dialect, @RequestHeader(value = "token") String token)
			throws FirebaseAuthException, AccessDeniedException {

		String uid = firebaseVerification.getUserIdFromIdToken(token);
		return new ResponseEntity<>(dictionnaireServices.listerLesMotsAValider(dialect, uid), HttpStatus.OK);

	}

	/**
	 * @param ligneDictionnaireForm
	 * @return ResponseEntity<LigneDictionnaireForm>
	 * @throws FirebaseAuthException
	 */
	@RequestMapping(value = { "/proposermodification", "/valider" }, method = RequestMethod.PUT)
	public ResponseEntity<LigneDictionnaireForm> validerOuProposerModification(
			@RequestBody LigneDictionnaireForm ligneDictionnaireForm, @RequestHeader("token") String token)
			throws FirebaseAuthException {

		String uid = firebaseVerification.getUserIdFromIdToken(token);
		return new ResponseEntity<>(dictionnaireServices.modifierUneLigneDictionnaire(ligneDictionnaireForm, uid),
				HttpStatus.OK);
	}

	/**
	 * @param ligneDictionnaireForm
	 * @return ResponseEntity<LigneDictionnaireForm>
	 * @throws FirebaseAuthException
	 * @throws AccessDeniedException 
	 */
	@RequestMapping(value = {"/ajoutermot"}, method = RequestMethod.POST)
	public ResponseEntity<LigneDictionnaireForm> ajouterUnMot(@RequestBody LigneDictionnaireForm ligneDictionnaireForm,
			@RequestHeader("token") String token) throws FirebaseAuthException, AccessDeniedException {

		String uid = firebaseVerification.getUserIdFromIdToken(token);
		
		return new ResponseEntity<>(dictionnaireServices.ajouterUnMot(ligneDictionnaireForm, uid),
				HttpStatus.OK);
	}

}
