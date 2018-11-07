package com.lh.kamusi.metier.services.impl;

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
import com.lh.kamusi.dao.entities.pk.DictionnairePk;
import com.lh.kamusi.dao.repository.DictionnaireRepository;
import com.lh.kamusi.dao.repository.DictionnaireTempRepository;
import com.lh.kamusi.dao.repository.MotsUsersRepository;
import com.lh.kamusi.dao.repository.UtilisateurRepository;
import com.lh.kamusi.metier.converter.DictionnaireEntiteToDictionnaireForm;
import com.lh.kamusi.metier.converter.DictionnaireFormToDictionnaireEntite;
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

		String role = ligneDictionnaire.getUtilisateur().getRole().getRole();
		UtilisateurEntite user = utilisateurRepository.getOne(uid);

		List<String> listeRoleMajor = Arrays.asList(RolesStatuts.ROLE_ADMIN.getValue(),
				RolesStatuts.ROLE_VALIDEUR.getValue());
		
		modificationHistorise.setDateModification(new Date());
		modificationHistorise.setIdUser(ligneDictionnaire.getUtilisateur().getIdUtilisateur());
		modificationHistorise.setMot(ligneDictionnaire.getMotFr());

		if (listeRoleMajor.contains(role.toUpperCase())) {

			ligneDictionnaire.getStatut().setStatut(RolesStatuts.STATUT_VALIDE.getValue());
			ligneDictionnaire.getStatut().setIdStatut(RolesStatuts.STATUT_VALIDE.getId());
			ligneDictionnaire.setDateModification(new Date());

			ligneDictionnaireForm = dictionnaireEntiteToDictionnaireForm.convert(dictionnaireRepository
					.saveAndFlush(dictionnaireFormToDictionnaireEntite.convert(ligneDictionnaire)));
			
			motsUsersRepository.save(modificationHistorise);

		} else {

			ligneDictionnaire.getStatut().setStatut(RolesStatuts.STATUT_AVALIDER.getValue());
			ligneDictionnaire.getStatut().setIdStatut(RolesStatuts.STATUT_AVALIDER.getId());
			ligneDictionnaire.setDateModification(new Date());

			LigneDictionnaireEntite ancienneLigne = dictionnaireRepository
					.chercherAncienneLigne(ligneDictionnaire.getMotFr());
			ancienneLigne.getStatut().setStatut(RolesStatuts.STATUT_AVALIDER.getValue());
			// ajout dans la table temporaire
			DictionnaireTempEntite ligneTemp = convertLigneDictionnaireToTemp(ligneDictionnaire, ligneDictionnaire.getDialectModifie(), user);
			
			dictionnaireTempRepository.saveAndFlush(ligneTemp);
			// suppression de l'ancienne ligne dans la table principale
			dictionnaireRepository.delete(ancienneLigne);

			ligneDictionnaireForm = dictionnaireEntiteToDictionnaireForm.convert(dictionnaireTempRepository
					.save(dictionnaireTempFormToDictionnaireEntite.convert(ligneDictionnaire)));

		}
		
		motsUsersRepository.save(modificationHistorise);

		return ligneDictionnaireForm;
	}

	private DictionnaireTempEntite convertLigneDictionnaireToTemp(LigneDictionnaireForm newProposition, String dialect, UtilisateurEntite user) {
		
		DictionnaireTempEntite ligneTemp = new DictionnaireTempEntite();
		ligneTemp.setDateModification(new Date());
		ligneTemp.setDefinitionCom(newProposition.getDefinitionFr());
		ligneTemp.setDefinitionFr(newProposition.getDefinitionFr());
		ligneTemp.setDialectModifie(dialect);
		DictionnairePk dictionnairePk = new DictionnairePk();
		dictionnairePk.setMotFr(newProposition.getMotFr());
		dictionnairePk.setMotNgz(newProposition.getMotNgz());
		ligneTemp.setDictionnairePk(dictionnairePk);
		ligneTemp.setMotAng(newProposition.getMotAng());
		ligneTemp.setMotMao(newProposition.getMotMao());
		ligneTemp.setMotMwa(newProposition.getMotMwa());
		ligneTemp.setMotNdz(newProposition.getMotNdz());
		ligneTemp.setStatut(new StatutEntite());
		ligneTemp.getStatut().setId_statut(RolesStatuts.STATUT_AVALIDER.getId());
		ligneTemp.getStatut().setStatut(RolesStatuts.STATUT_AVALIDER.getValue());
		ligneTemp.setSuggestion(newProposition.getSuggestion());
		
		ligneTemp.setUtilisateur(user);
		
		return ligneTemp;
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
