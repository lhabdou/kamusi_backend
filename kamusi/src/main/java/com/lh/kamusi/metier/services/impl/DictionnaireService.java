package com.lh.kamusi.metier.services.impl;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.kamusi.dao.entities.DictionnaireTempEntite;
import com.lh.kamusi.dao.entities.LigneDictionnaireEntite;
import com.lh.kamusi.dao.entities.MotsUsersEntite;
import com.lh.kamusi.dao.entities.StatutEntite;
import com.lh.kamusi.dao.entities.UtilisateurEntite;
import com.lh.kamusi.dao.repository.DictionnaireRepository;
import com.lh.kamusi.dao.repository.DictionnaireTempRepository;
import com.lh.kamusi.dao.repository.MotsUsersRepository;
import com.lh.kamusi.dao.repository.UtilisateurRepository;
import com.lh.kamusi.metier.converter.DictionnaireEntiteToDictionnaireForm;
import com.lh.kamusi.metier.converter.DictionnaireFormToDictionnaireEntite;
import com.lh.kamusi.metier.converter.UtilisateurEntiteToUtilisateurForm;
import com.lh.kamusi.metier.domain.LigneDictionnaireForm;
import com.lh.kamusi.metier.services.IDictionnaireService;
import com.lh.kamusi.metier.services.impl.enumerateur.RolesStatuts;

@Service
public class DictionnaireService implements IDictionnaireService {

	public static final String ANG = "ang";

	public static final String NGZ = "ngz";

	public static final String FR = "fr";

	@Autowired
	private DictionnaireRepository dictionnaireRepository;

	@Autowired
	UtilisateurEntiteToUtilisateurForm utilisateurEntiteToUserForm;

	@Autowired
	private UtilisateurRepository utilisateurRepository;

	@Autowired
	private MotsUsersRepository motsUsersRepository;

	@Autowired
	private DictionnaireTempRepository dictionnaireTempRepository;

	@Autowired
	private DictionnaireEntiteToDictionnaireForm dictionnaireEntiteToDictionnaireForm;

	@Autowired
	private DictionnaireFormToDictionnaireEntite dictionnaireFormToDictionnaireEntite;

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.lh.kamusi.metier.services.IDictionnaireService#listerLesmotsFr(java.lang.String)
	 */
	@Override
	public List<LigneDictionnaireForm> listerLesMots(String motCle, String langue) {

		List<LigneDictionnaireEntite> lignesDictionnaireEntites = null;

		switch (langue.toLowerCase()) {

		case FR:
			lignesDictionnaireEntites = dictionnaireRepository.listerLesMotsFr(motCle.toLowerCase());

			break;
		case NGZ:
			lignesDictionnaireEntites = dictionnaireRepository.listerLesMotsNgz(motCle.toLowerCase());

			break;

		case ANG:
			lignesDictionnaireEntites = dictionnaireRepository.listerLesMotsAng(motCle.toLowerCase());

			break;

		default:
			break;
		}

		return transformerMotsEntiteEnMotsForm(lignesDictionnaireEntites);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.lh.kamusi.metier.services.IDictionnaireService#
	 *      ajouterUneLigneDictionnaire(com.lh.kamusi.metier.domain.LigneDictionnaireForm)
	 */
	@Override
	public LigneDictionnaireForm ajouterUneLigneDictionnaire(LigneDictionnaireForm ligneDictionnaire) {

		LigneDictionnaireEntite ligneDictionnaireEntite = dictionnaireRepository
				.save(dictionnaireFormToDictionnaireEntite.convert(ligneDictionnaire));

		return dictionnaireEntiteToDictionnaireForm.convert(ligneDictionnaireEntite);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.lh.kamusi.metier.services.IDictionnaireService#
	 *      validerUneLigneDictionnaire(com.lh.kamusi.metier.domain.LigneDictionnaireForm,
	 *      java.lang.Boolean)
	 */
	@Override
	public LigneDictionnaireForm validerUneLigneDictionnaire(LigneDictionnaireForm ligneDictionnaire,
			Boolean motComModifie) {

		LigneDictionnaireForm ligneDictionnaireForm = null;

		if (motComModifie) {

			dictionnaireRepository.delete(dictionnaireRepository.chercherAncienneLigne(ligneDictionnaire.getMotFr()));

			ligneDictionnaireForm = dictionnaireEntiteToDictionnaireForm.convert(
					dictionnaireRepository.save(dictionnaireFormToDictionnaireEntite.convert(ligneDictionnaire)));

		} else {

			ligneDictionnaireForm = dictionnaireEntiteToDictionnaireForm.convert(
					dictionnaireRepository.save(dictionnaireFormToDictionnaireEntite.convert(ligneDictionnaire)));

		}
		return ligneDictionnaireForm;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.lh.kamusi.metier.services.IDictionnaireService#
	 *      supprimerUneLigneDictionnaire(com.lh.kamusi.metier.domain.LigneDictionnaireForm)
	 */
	@Override
	public void supprimerUneLigneDictionnaire(LigneDictionnaireForm ligneDictionnaire) {

		dictionnaireRepository.delete(dictionnaireFormToDictionnaireEntite.convert(ligneDictionnaire));

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.lh.kamusi.metier.services.IDictionnaireService#
	 *      modifierUneLigneDictionnaire(com.lh.kamusi.metier.domain.LigneDictionnaireForm)
	 */
	@Override
	public LigneDictionnaireForm modifierUneLigneDictionnaire(LigneDictionnaireForm ligneDictionnaire, String uid) {

		LigneDictionnaireForm ligneDictionnaireForm;
		MotsUsersEntite modificationHistorise = new MotsUsersEntite();

		UtilisateurEntite user = utilisateurRepository.getUserIfExist(uid);
		String role = user.getRole().getNom_role();

		List<String> listeRoleMajor = Arrays.asList(RolesStatuts.ROLE_ADMIN.getValue(),
				RolesStatuts.ROLE_VALIDEUR.getValue());

		LigneDictionnaireEntite ancienneLigne = dictionnaireRepository
				.chercherAncienneLigne(ligneDictionnaire.getMotFr().toLowerCase());

		// ligne temp
		DictionnaireTempEntite ligneTemp = dictionnaireFormToDictionnaireEntite.convertTemp(ligneDictionnaire);

		modificationHistorise.setDateModification(new Date());
		modificationHistorise.setIdUser(ligneDictionnaire.getUtilisateur().getIdUtilisateur());
		modificationHistorise.setMot(ligneDictionnaire.getMotFr());

		if (listeRoleMajor.contains(role.toUpperCase())) {

			// En validant une modification en comorien on suprrime l'ancienne ligne
			// pour éviter les doublons

			if ("ngz".equalsIgnoreCase(ligneDictionnaire.getDialectModifie())) {
				// suppression de l'ancienne ligne dans la table principale
				dictionnaireRepository.delete(ancienneLigne);
			}

			ligneDictionnaire.getStatut().setStatut(RolesStatuts.STATUT_VALIDE.getValue());
			ligneDictionnaire.getStatut().setIdStatut(RolesStatuts.STATUT_VALIDE.getId());
			ligneDictionnaire.setDateModification(new Date());

			ligneDictionnaireForm = dictionnaireEntiteToDictionnaireForm.convert(dictionnaireRepository
					.saveAndFlush(dictionnaireFormToDictionnaireEntite.convert(ligneDictionnaire)));

			motsUsersRepository.save(modificationHistorise);

			// Suppresion de la ligne temp dans la table temporaire ou passage en statuts
			// Valide

			dictionnaireTempRepository.saveAndFlush(ligneTemp);

		} else {
			// si user différent du dernier modificateur
			// on attribue la modification au nouveau user

			if (ligneDictionnaire.getUtilisateur().getIdUtilisateur() != uid) {

				ligneDictionnaire.setUtilisateur(utilisateurEntiteToUserForm.convert(user));

			}

			ligneDictionnaire.getStatut().setStatut(RolesStatuts.STATUT_AVALIDER.getValue());
			ligneDictionnaire.getStatut().setIdStatut(RolesStatuts.STATUT_AVALIDER.getId());
			ligneDictionnaire.setDateModification(new Date());

			// s'il s'agit d'une suggestion

			if ("sug".equalsIgnoreCase(ligneDictionnaire.getDialectModifie())) {

				ancienneLigne.setSuggestion(ligneDictionnaire.getSuggestion());

			} else {
				// changer de statut
				ancienneLigne.setStatut(new StatutEntite());
				ancienneLigne.getStatut().setId_statut(RolesStatuts.STATUT_AVALIDER.getId());
				ancienneLigne.getStatut().setStatut(RolesStatuts.STATUT_AVALIDER.getValue());
			}

			dictionnaireRepository.save(ancienneLigne);

			// ajout dans la table temporaire
			ligneDictionnaireForm = dictionnaireEntiteToDictionnaireForm
					.convertTemp(dictionnaireTempRepository.saveAndFlush(ligneTemp));

		}

		motsUsersRepository.save(modificationHistorise);

		return ligneDictionnaireForm;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.lh.kamusi.metier.services.IDictionnaireService#listerLesMotsAValider(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public List<LigneDictionnaireForm> listerLesMotsAValider(String dialect, String uid) throws AccessDeniedException {
		List<DictionnaireTempEntite> motsAvalider;
		UtilisateurEntite userEntite = utilisateurRepository.getUserIfExist(uid);
		if (RolesStatuts.ROLE_ADMIN.getValue().equalsIgnoreCase(userEntite.getRole().getNom_role())
				|| RolesStatuts.ROLE_VALIDEUR.getValue().equalsIgnoreCase(userEntite.getRole().getNom_role())) {

			motsAvalider = dictionnaireTempRepository.listerLesMots(dialect);

		} else {
			throw new AccessDeniedException("Accès refusé");
		}

		return transformerMotsEntiteEnMotsFormTemp(motsAvalider);
	}

	/**
	 * @param lignesDictionnaireEntites
	 * @return
	 */
	private List<LigneDictionnaireForm> transformerMotsEntiteEnMotsForm(
			List<LigneDictionnaireEntite> lignesDictionnaireEntites) {
		List<LigneDictionnaireForm> ligneDictionnaireForms = new ArrayList<>();
		if (lignesDictionnaireEntites != null) {

			for (LigneDictionnaireEntite ligneDictionnaireE : lignesDictionnaireEntites) {

				ligneDictionnaireForms.add(dictionnaireEntiteToDictionnaireForm.convert(ligneDictionnaireE));

			}
		}

		return ligneDictionnaireForms;
	}

	/**
	 * @param motsAvalider
	 * @return List<LigneDictionnaireForm>
	 */
	private List<LigneDictionnaireForm> transformerMotsEntiteEnMotsFormTemp(List<DictionnaireTempEntite> motsAvalider) {

		List<LigneDictionnaireForm> ligneDictionnaireForms = new ArrayList<>();

		for (DictionnaireTempEntite ligneDictionnaire : motsAvalider) {

			ligneDictionnaireForms.add(dictionnaireEntiteToDictionnaireForm.convertTemp(ligneDictionnaire));

		}
		return ligneDictionnaireForms;
	}

	/**
	 * @param dictionnaireRepository the dictionnaireRepository to set
	 */
	public void setDictionnaireRepository(DictionnaireRepository dictionnaireRepository) {
		this.dictionnaireRepository = dictionnaireRepository;
	}

}
