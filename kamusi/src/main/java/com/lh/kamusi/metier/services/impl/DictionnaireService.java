package com.lh.kamusi.metier.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.kamusi.dao.entities.DictionnaireTempEntite;
import com.lh.kamusi.dao.entities.LigneDictionnaireEntite;
import com.lh.kamusi.dao.repository.DictionnaireRepository;
import com.lh.kamusi.dao.repository.DictionnaireTempRepository;
import com.lh.kamusi.metier.converter.DictionnaireEntiteToDictionnaireForm;
import com.lh.kamusi.metier.converter.DictionnaireFormToDictionnaireEntite;
import com.lh.kamusi.metier.domain.LigneDictionnaireForm;
import com.lh.kamusi.metier.services.IDictionnaireService;
import com.lh.kamusi.metier.services.impl.enumerateur.EnumUtils;

@Service
public class DictionnaireService implements IDictionnaireService {

	@Autowired
	private DictionnaireRepository dictionnaireRepository;

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
	public List<LigneDictionnaireForm> listerLesmotsFr(String motCle) {

		List<LigneDictionnaireEntite> lignesDictionnaireEntites = dictionnaireRepository
				.listerLesMots(motCle.toLowerCase());

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
	public LigneDictionnaireForm modifierUneLigneDictionnaire(LigneDictionnaireForm ligneDictionnaire) {

		LigneDictionnaireForm ligneDictionnaireForm = new LigneDictionnaireForm();

		String role = ligneDictionnaireForm.getUtilisateur().getRole().getRole();

		List<String> listeRoleMajor = Arrays.asList(EnumUtils.ROLE_ADMIN.getValue(),
				EnumUtils.ROLE_CONTRIBUTEUR.getValue());

		if (listeRoleMajor.contains(role.toUpperCase())) {

			ligneDictionnaire.getStatut().setStatut(EnumUtils.STATUT_VALIDE.getValue());
			ligneDictionnaire.getStatut().setId_statut(EnumUtils.STATUT_VALIDE.getId());
			ligneDictionnaire.setDateModification(new Date());

			ligneDictionnaireForm = dictionnaireEntiteToDictionnaireForm.convert(dictionnaireRepository
					.saveAndFlush(dictionnaireFormToDictionnaireEntite.convert(ligneDictionnaire)));

		} else {

			ligneDictionnaire.getStatut().setStatut(EnumUtils.STATUT_AVALIDER.getValue());
			ligneDictionnaire.getStatut().setId_statut(EnumUtils.STATUT_AVALIDER.getId());
			ligneDictionnaire.setDateModification(new Date());

			LigneDictionnaireEntite ancienneLigne = dictionnaireRepository
					.chercherAncienneLigne(ligneDictionnaire.getMotFr());
			ancienneLigne.getStatut().setStatut(EnumUtils.STATUT_AVALIDER.getValue());
			// ajout dans la table temporaire
			dictionnaireTempRepository.saveAndFlush(ancienneLigne);
			// suppression de l'ancienne ligne dans la table principale
			dictionnaireRepository.delete(ancienneLigne);

			ligneDictionnaireForm = dictionnaireEntiteToDictionnaireForm.convert(dictionnaireTempRepository
					.saveAndFlush(dictionnaireFormToDictionnaireEntite.convert(ligneDictionnaire)));

		}

		return ligneDictionnaireForm;
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.lh.kamusi.metier.services.IDictionnaireService#listerLesmotsAvalider()
	 */
	@Override
	public List<LigneDictionnaireForm> listerLesmotsAvalider() {
		List<DictionnaireTempEntite> motsAvalider = dictionnaireTempRepository.listerLesMots();

		return transformerMotsEntiteEnMotsFormTemp(motsAvalider);
	}

	/**
	 * @param lignesDictionnaireEntites
	 * @return
	 */
	private List<LigneDictionnaireForm> transformerMotsEntiteEnMotsForm(
			List<LigneDictionnaireEntite> lignesDictionnaireEntites) {
		List<LigneDictionnaireForm> ligneDictionnaireForms = new ArrayList<>();

		for (LigneDictionnaireEntite ligneDictionnaireE : lignesDictionnaireEntites) {

			ligneDictionnaireForms.add(dictionnaireEntiteToDictionnaireForm.convert(ligneDictionnaireE));

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
