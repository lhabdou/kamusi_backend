package com.lh.kamusi.metier.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lh.kamusi.dao.entities.LigneDictionnaireEntite;
import com.lh.kamusi.metier.domain.LigneDictionnaireForm;

@Component
public class LigneDictionnaireEntiteToLigneDictionnaireForm implements Converter<LigneDictionnaireEntite, LigneDictionnaireForm> {
	
	@Autowired
	UtilisateurEntiteToUtilisateurForm utilisateurConvert; 
	
	@Override
	public LigneDictionnaireForm convert(LigneDictionnaireEntite dictionnaireEntite) {
		LigneDictionnaireForm dictionnaire = new LigneDictionnaireForm(); 
		
		dictionnaire.setMot_fr(dictionnaireEntite.getDictionnairePk().getMot_fr());
		dictionnaire.setMot_ngz(dictionnaireEntite.getDictionnairePk().getMot_ngz());
		dictionnaire.setMot_ang(dictionnaireEntite.getMot_ang());
		dictionnaire.setMot_ndz(dictionnaireEntite.getMot_ndz());
		dictionnaire.setMot_mao(dictionnaireEntite.getMot_mao());
		dictionnaire.setMot_mwa(dictionnaireEntite.getMot_mwa());
		dictionnaire.setSuggestion(dictionnaireEntite.getSuggestion());
		dictionnaire.setDefinition_com(dictionnaireEntite.getDefinition_com());
		dictionnaire.setDefinition_fr(dictionnaireEntite.getDefinition_fr());
		dictionnaire.setUtilisateur(utilisateurConvert.convert(dictionnaireEntite.getUtilisateur()));
		
		return dictionnaire;
	}
}
