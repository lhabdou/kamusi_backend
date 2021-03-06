/**
 * 
 */
package com.lh.kamusi.metier.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.kamusi.dao.entities.LigneDictionnaireEntite;
import com.lh.kamusi.dao.entities.UtilisateurEntite;
import com.lh.kamusi.dao.repository.DictionnaireRepository;
import com.lh.kamusi.dao.repository.UtilisateurRepository;
import com.lh.kamusi.metier.converter.UtilisateurEntiteToUtilisateurForm;
import com.lh.kamusi.metier.converter.UtilisateurFormToUtilisateurEntite;
import com.lh.kamusi.metier.domain.UtilisateurForm;
import com.lh.kamusi.metier.services.IUtilisateurService;

/**
 * @author asoilihi
 *
 */
@Service
@Transactional
public class UtilisateurService implements IUtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private DictionnaireRepository dictionnaireRepository;

	@Autowired
	private UtilisateurEntiteToUtilisateurForm utilisateurEntiteToUtilisateurForm;

	@Autowired
	private UtilisateurFormToUtilisateurEntite utilisateurFormToUtilisateurEntite;

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.lh.kamusi.metier.services.IUtilisateurService#
	 *      listerLesUtilisateurs(java.lang.String)
	 */
	@Override
	public List<UtilisateurForm> listerLesUtilisateurs(String role) {
		List<UtilisateurEntite> listEntite = utilisateurRepository.listerLesUtilisateursRole(role.toUpperCase());

		return utilisateurEntiteToUtilisateurForm.convertList(listEntite);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.lh.kamusi.metier.services.IUtilisateurService#
	 *      enregistrerUtilisateur(com.lh.kamusi.metier.domain.UtilisateurForm)
	 */
	@Override
	public UtilisateurForm enregistrerUtilisateur(UtilisateurForm utilisateurForm) {
		UtilisateurEntite userEntite = utilisateurFormToUtilisateurEntite.convert(utilisateurForm);
		UtilisateurEntite userSaved = utilisateurRepository.save(userEntite);
		return utilisateurEntiteToUtilisateurForm.convert(userSaved);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.lh.kamusi.metier.services.IUtilisateurService#
	 *      supprimerUtilisateur(com.lh.kamusi.metier.domain.UtilisateurForm)
	 */
	@Override
	public void supprimerUtilisateur(String uid) {
		List<LigneDictionnaireEntite> motsUser = dictionnaireRepository.listerLesMotsParUserId(uid);

		if (motsUser != null && !motsUser.isEmpty()) {

			UtilisateurEntite admin = utilisateurRepository.getAdminUser();

			for (LigneDictionnaireEntite ligneDictionnaireEntite : motsUser) {

				ligneDictionnaireEntite.setUtilisateur(admin);

			}

			dictionnaireRepository.saveAll(motsUser);
		}

		utilisateurRepository.deleteById(uid);

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.lh.kamusi.metier.services.IUtilisateurService#tousListerLesUtilisateurs()
	 */
	@Override
	public List<UtilisateurForm> tousListerLesUtilisateurs() {

		return utilisateurEntiteToUtilisateurForm.convertList(utilisateurRepository.findAll());
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.lh.kamusi.metier.services.IUtilisateurService#getProfileUtilisateur(java.lang.String)
	 */
	@Override
	public UtilisateurForm getProfileUtilisateur(String uid) {

		return utilisateurEntiteToUtilisateurForm.convert(utilisateurRepository.getUserIfExist(uid));

	}

}
