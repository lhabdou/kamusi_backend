/**
 * 
 */
package com.lh.kamusi.metier.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.kamusi.dao.entities.UtilisateurEntite;
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
public class UtilisateurService implements IUtilisateurService {

	@Autowired
	private UtilisateurRepository utilisateurRepository;

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
	 * @see com.lh.kamusi.metier.services.IUtilisateurService#
	 *      enregistrerUtilisateur(com.lh.kamusi.metier.domain.UtilisateurForm)
	 */
	@Override
	public UtilisateurForm enregistrerUtilisateur(UtilisateurForm utilisateurForm) {

		return utilisateurEntiteToUtilisateurForm
				.convert(utilisateurRepository.save(utilisateurFormToUtilisateurEntite.convert(utilisateurForm)));
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.lh.kamusi.metier.services.IUtilisateurService#
	 *      supprimerUtilisateur(com.lh.kamusi.metier.domain.UtilisateurForm)
	 */
	@Override
	public void supprimerUtilisateur(String uid) {

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

		return utilisateurEntiteToUtilisateurForm.convert(utilisateurRepository.getOne(uid));
	}

}
