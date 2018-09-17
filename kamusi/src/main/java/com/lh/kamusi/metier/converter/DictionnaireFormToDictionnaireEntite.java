package com.lh.kamusi.metier.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lh.kamusi.dao.entities.DictionnaireTempEntite;
import com.lh.kamusi.dao.entities.LigneDictionnaireEntite;
import com.lh.kamusi.dao.entities.pk.Dictionnaire_PK;
import com.lh.kamusi.metier.domain.LigneDictionnaireForm;

@Component
public class DictionnaireFormToDictionnaireEntite implements Converter<LigneDictionnaireForm, LigneDictionnaireEntite> {
	

	@Override
	public LigneDictionnaireEntite convert(LigneDictionnaireForm dictionnaireForm) {
		LigneDictionnaireEntite dictionnaireEntite = new LigneDictionnaireEntite();
		
		Dictionnaire_PK dictionnairePk = new Dictionnaire_PK();
		dictionnairePk.setMot_fr(dictionnaireForm.getMot_fr());
		dictionnairePk.setMot_ngz(dictionnaireForm.getMot_ngz());
		dictionnaireEntite.setDictionnairePk(dictionnairePk );
		dictionnaireEntite.setMot_ang(dictionnaireForm.getMot_ang());
		dictionnaireEntite.setMot_ndz(dictionnaireForm.getMot_ndz());
		dictionnaireEntite.setMot_mao(dictionnaireForm.getMot_mao());
		dictionnaireEntite.setMot_mwa(dictionnaireForm.getMot_mwa());
		dictionnaireEntite.setSuggestion(dictionnaireForm.getSuggestion());
		dictionnaireEntite.setDefinition_com(dictionnaireForm.getDefinition_com());
		dictionnaireEntite.setDefinition_fr(dictionnaireForm.getDefinition_fr());	
		
		return dictionnaireEntite;
	}
	
	
	public DictionnaireTempEntite convertTemp(LigneDictionnaireForm dictionnaireForm) {
		DictionnaireTempEntite dictionnaireEntite = new DictionnaireTempEntite();
		
		Dictionnaire_PK dictionnairePk = new Dictionnaire_PK();
		dictionnairePk.setMot_fr(dictionnaireForm.getMot_fr());
		dictionnairePk.setMot_ngz(dictionnaireForm.getMot_ngz());
		dictionnaireEntite.setDictionnairePk(dictionnairePk );
		dictionnaireEntite.setMot_ang(dictionnaireForm.getMot_ang());
		dictionnaireEntite.setMot_ndz(dictionnaireForm.getMot_ndz());
		dictionnaireEntite.setMot_mao(dictionnaireForm.getMot_mao());
		dictionnaireEntite.setMot_mwa(dictionnaireForm.getMot_mwa());
		dictionnaireEntite.setSuggestion(dictionnaireForm.getSuggestion());
		dictionnaireEntite.setDefinition_com(dictionnaireForm.getDefinition_com());
		dictionnaireEntite.setDefinition_fr(dictionnaireForm.getDefinition_fr());	
		
		return dictionnaireEntite;
	}
}
