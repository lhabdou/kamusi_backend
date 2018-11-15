package com.lh.kamusi.metier.converter;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lh.kamusi.dao.entities.DictionnaireTempEntite;
import com.lh.kamusi.dao.entities.LigneDictionnaireEntite;
import com.lh.kamusi.dao.entities.pk.DictionnairePk;
import com.lh.kamusi.metier.domain.LigneDictionnaireForm;

@Component
public class DictionnaireFormToDictionnaireEntite implements Converter<LigneDictionnaireForm, LigneDictionnaireEntite> {

	@Autowired
	private StatutFormToStatutEntite statutFormToStatutEntite;
	
	@Autowired
	private UtilisateurFormToUtilisateurEntite utilisateurFormToUtilisateurEntite;

	@Override
	public LigneDictionnaireEntite convert(LigneDictionnaireForm dictionnaireForm) {
		LigneDictionnaireEntite dictionnaireEntite = new LigneDictionnaireEntite();

		DictionnairePk dictionnairePk = new DictionnairePk();
		dictionnairePk.setMotFr(dictionnaireForm.getMotFr());
		dictionnairePk.setMotNgz(dictionnaireForm.getMotNgz());
		dictionnaireEntite.setDictionnairePk(dictionnairePk);
		dictionnaireEntite.setMotAng(dictionnaireForm.getMotAng());
		dictionnaireEntite.setMotNdz(dictionnaireForm.getMotNdz());
		dictionnaireEntite.setMotMao(dictionnaireForm.getMotMao());
		dictionnaireEntite.setMotMwa(dictionnaireForm.getMotMwa());
		dictionnaireEntite.setSuggestion(dictionnaireForm.getSuggestion());
		dictionnaireEntite.setDefinitionCom(dictionnaireForm.getDefinitionCom());
		dictionnaireEntite.setDefinitionFr(dictionnaireForm.getDefinitionFr());
		dictionnaireEntite.setStatut(statutFormToStatutEntite.convert(dictionnaireForm.getStatut()));
		dictionnaireEntite.setUtilisateur(utilisateurFormToUtilisateurEntite.convert(dictionnaireForm.getUtilisateur()));
		
		return dictionnaireEntite;
	}

	public DictionnaireTempEntite convertTemp(LigneDictionnaireForm dictionnaireForm) {
		DictionnaireTempEntite dictionnaireEntite = new DictionnaireTempEntite();

		DictionnairePk dictionnairePk = new DictionnairePk();
		dictionnairePk.setMotFr(dictionnaireForm.getMotFr());
		dictionnairePk.setMotNgz(dictionnaireForm.getMotNgz());
		dictionnaireEntite.setDictionnairePk(dictionnairePk);
		dictionnaireEntite.setMotAng(dictionnaireForm.getMotAng());
		dictionnaireEntite.setMotNdz(dictionnaireForm.getMotNdz());
		dictionnaireEntite.setMotMao(dictionnaireForm.getMotMao());
		dictionnaireEntite.setMotMwa(dictionnaireForm.getMotMwa());
		dictionnaireEntite.setSuggestion(dictionnaireForm.getSuggestion());
		dictionnaireEntite.setDefinitionCom(dictionnaireForm.getDefinitionCom());
		dictionnaireEntite.setDefinitionFr(dictionnaireForm.getDefinitionFr());
		dictionnaireEntite.setDialectModifie(dictionnaireForm.getDialectModifie());
		dictionnaireEntite.setDateModification(new Date());
		dictionnaireEntite.setStatut(statutFormToStatutEntite.convert(dictionnaireForm.getStatut()));
		dictionnaireEntite.setUtilisateur(utilisateurFormToUtilisateurEntite.convert(dictionnaireForm.getUtilisateur()));


		return dictionnaireEntite;
	}
}
