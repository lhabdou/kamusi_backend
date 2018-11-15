package com.lh.kamusi.metier.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lh.kamusi.dao.entities.DictionnaireTempEntite;
import com.lh.kamusi.dao.entities.LigneDictionnaireEntite;
import com.lh.kamusi.metier.domain.LigneDictionnaireForm;

@Component
public class DictionnaireEntiteToDictionnaireForm implements Converter<LigneDictionnaireEntite, LigneDictionnaireForm> {
	
	@Autowired
	UtilisateurEntiteToUtilisateurForm utilisateurConvert; 
	
	@Autowired
	StatutEntiteToStatutForm statutEntiteToStatutForm;
	
	
	@Override
	public LigneDictionnaireForm convert(LigneDictionnaireEntite dictionnaireEntite) {
		LigneDictionnaireForm dictionnaire = new LigneDictionnaireForm(); 
		
		dictionnaire.setMotFr(dictionnaireEntite.getDictionnairePk().getMotFr());
		dictionnaire.setMotNgz(dictionnaireEntite.getDictionnairePk().getMotNgz());
		dictionnaire.setMotAng(dictionnaireEntite.getMotAng());
		dictionnaire.setMotNdz(dictionnaireEntite.getMotNdz());
		dictionnaire.setMotMao(dictionnaireEntite.getMotMao());
		dictionnaire.setMotMwa(dictionnaireEntite.getMotMwa());
		dictionnaire.setSuggestion(dictionnaireEntite.getSuggestion());
		dictionnaire.setDefinitionCom(dictionnaireEntite.getDefinitionCom());
		dictionnaire.setDefinitionFr(dictionnaireEntite.getDefinitionFr());
		dictionnaire.setUtilisateur(utilisateurConvert.convert(dictionnaireEntite.getUtilisateur()));
		dictionnaire.setStatut(statutEntiteToStatutForm.convert(dictionnaireEntite.getStatut()));
		
		return dictionnaire;
	}
	
	
	public LigneDictionnaireForm convertTemp(DictionnaireTempEntite dictionnaireEntite) {
		LigneDictionnaireForm dictionnaire = new LigneDictionnaireForm(); 
		
		dictionnaire.setMotFr(dictionnaireEntite.getDictionnairePk().getMotFr());
		dictionnaire.setMotNgz(dictionnaireEntite.getDictionnairePk().getMotNgz());
		dictionnaire.setMotAng(dictionnaireEntite.getMotAng());
		dictionnaire.setMotNdz(dictionnaireEntite.getMotNdz());
		dictionnaire.setMotMao(dictionnaireEntite.getMotMao());
		dictionnaire.setMotMwa(dictionnaireEntite.getMotMwa());
		dictionnaire.setSuggestion(dictionnaireEntite.getSuggestion());
		dictionnaire.setDefinitionCom(dictionnaireEntite.getDefinitionCom());
		
		dictionnaire.setDefinitionFr(dictionnaireEntite.getDefinitionFr());
		dictionnaire.setDialectModifie(dictionnaireEntite.getDialectModifie());
		
		dictionnaire.setDateModification(dictionnaireEntite.getDateModification());
		dictionnaire.setUtilisateur(utilisateurConvert.convert(dictionnaireEntite.getUtilisateur()));
		dictionnaire.setStatut(statutEntiteToStatutForm.convert(dictionnaireEntite.getStatut()));

		
		return dictionnaire;
	}
}
