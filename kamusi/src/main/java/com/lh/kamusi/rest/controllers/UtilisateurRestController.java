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

import com.lh.kamusi.metier.domain.UtilisateurForm;
import com.lh.kamusi.metier.services.IUtilisateurService;

/**
 * @author asoilihi
 *
 */
@RestController
@CrossOrigin("http://localhost:8100")
@RequestMapping(value = "/kamusi", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
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
	 * @throws FirebaseAuthException
	 */
	@RequestMapping(value = "/utilisateurs/nouveau", method = RequestMethod.POST)
	public ResponseEntity<UtilisateurForm> ajouterUnUtilisateur(@RequestHeader(value = "token") String idToken,
			@RequestHeader(value = "uid") String uid, @RequestBody UtilisateurForm utilisateurForm) {

		return enregistrerOuModifierUtilisateur(uid, utilisateurForm);

	}

	/**
	 * Mettre à jour un Utilisateur
	 * 
	 * @param utilisateurForm
	 * @return ResponseEntity<UtilisateurForm>
	 * @throws FirebaseAuthException
	 */
	@RequestMapping(value = "/utilisateurs/maj", method = RequestMethod.PUT)
	public ResponseEntity<UtilisateurForm> majUtilisateur(@RequestHeader(value = "token") String idToken, @RequestHeader(value = "uid") String uid,
			@RequestBody UtilisateurForm utilisateurForm) {

		return enregistrerOuModifierUtilisateur(uid, utilisateurForm);

	}

	/**
	 * Supprimer un utilisateur
	 * 
	 * @param utilisateurForm
	 * @return ResponseEntity<UtilisateurForm>
	 * @throws FirebaseAuthException
	 */
	@RequestMapping(value = "/utilisateurs/supprimer/{idUser}", method = RequestMethod.DELETE)
	public void supprimerUnUtilisateur(@RequestHeader(value = "token") String token,
			@RequestHeader(value = "uid") String uid, @PathVariable(value = "idUser") String idUser) {
		utilisateurService.supprimerUtilisateur(uid);

	}

	/**
	 * récupérer un utilisateur
	 * 
	 * @param utilisateurForm
	 * @return ResponseEntity<UtilisateurForm>
	 * @throws FirebaseAuthException
	 */
	@RequestMapping(value = "/utilisateurs/profil", method = RequestMethod.POST)
	public ResponseEntity<UtilisateurForm> getProfileUtilisateur(@RequestHeader(value = "token") String token,
			@RequestHeader(value = "uid") String uid, @RequestBody (required = false) UtilisateurForm userFormFr) {

		return new ResponseEntity<>(utilisateurService.getProfileUtilisateur(uid), HttpStatus.OK);

	}

	/**
	 * Mettre à jour un Utilisateur
	 * 
	 * @param utilisateurForm
	 * @return ResponseEntity<UtilisateurForm>
	 * @throws FirebaseAuthException
	 */
	@RequestMapping(value = "/utilisateurs/modifier", method = RequestMethod.PUT)
	public ResponseEntity<UtilisateurForm> modifierUnUtilisateur(@RequestHeader(value = "token") String idToken,@RequestHeader(value = "uid") String uid,
			@RequestBody UtilisateurForm utilisateurForm)  {

		return enregistrerOuModifierUtilisateur(uid, utilisateurForm);

	}

	/**
	 * @param id
	 * @param utilisateurForm
	 * @return ResponseEntity<UtilisateurForm>
	 * @throws FirebaseAuthException
	 */
	private ResponseEntity<UtilisateurForm> enregistrerOuModifierUtilisateur(String uid, UtilisateurForm utilisateurForm) {

		utilisateurForm.setIdUtilisateur(uid);

		return new ResponseEntity<>(utilisateurService.enregistrerUtilisateur(utilisateurForm), HttpStatus.OK);
	}

}
