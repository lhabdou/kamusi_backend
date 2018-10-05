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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.lh.kamusi.metier.domain.UtilisateurForm;
import com.lh.kamusi.metier.services.IUtilisateurService;
import com.lh.kamusi.rest.firebase.FirebaseVerification;

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
	 * le service firebase
	 */
	@Autowired
	private FirebaseVerification firebaseVerification;

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
			@RequestBody UtilisateurForm utilisateurForm) throws FirebaseAuthException {

		utilisateurForm.setIdUtilisateur(firebaseVerification.getUserIdFromIdToken(idToken));

		return new ResponseEntity<>(utilisateurService.enregistrerUtilisateur(utilisateurForm), HttpStatus.OK);

	}

	/**
	 * Supprimer un utilisateur
	 * 
	 * @param utilisateurForm
	 * @return ResponseEntity<UtilisateurForm>
	 * @throws FirebaseAuthException
	 */
	@RequestMapping(value = "/utilisateurs/supprimer", method = RequestMethod.DELETE)
	public void supprimerUnUtilisateur(@RequestHeader(value = "token") String token,
			@RequestBody UtilisateurForm utilisateurForm) throws FirebaseAuthException {
		String uid = firebaseVerification.getUserIdFromIdToken(token);
		utilisateurService.supprimerUtilisateur(uid);
		FirebaseAuth.getInstance().deleteUser(uid);

	}

	/**
	 * récupérer un utilisateur
	 * 
	 * @param utilisateurForm
	 * @return ResponseEntity<UtilisateurForm>
	 * @throws FirebaseAuthException
	 */
	@RequestMapping(value = "/utilisateurs/profil", method = RequestMethod.GET)
	public ResponseEntity<UtilisateurForm> getProfileUtilisateur(@RequestHeader(value = "token") String token)
			throws FirebaseAuthException {
		return new ResponseEntity<>(
				utilisateurService.getProfileUtilisateur(firebaseVerification.getUserIdFromIdToken(token)),
				HttpStatus.OK);

	}
	
	/**
	 * Mettre à jour un Utilisateur
	 * 
	 * @param utilisateurForm
	 * @return ResponseEntity<UtilisateurForm>
	 * @throws FirebaseAuthException
	 */
	@RequestMapping(value = "/utilisateurs/modifier", method = RequestMethod.PUT)
	public ResponseEntity<UtilisateurForm> modifierUnUtilisateur(@RequestHeader(value = "token") String idToken,
			@RequestBody UtilisateurForm utilisateurForm) throws FirebaseAuthException {

		utilisateurForm.setIdUtilisateur(firebaseVerification.getUserIdFromIdToken(idToken));

		return new ResponseEntity<>(utilisateurService.enregistrerUtilisateur(utilisateurForm), HttpStatus.OK);

	}

}
