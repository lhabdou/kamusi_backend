package com.lh.kamusi.metier.mapper;

import java.util.ArrayList;
import java.util.List;

import com.lh.kamusi.dao.entities.LigneDictionnaireEntite;
import com.lh.kamusi.metier.domain.LigneDictionnaire;

public class DictionnaireMapper {
	
	public DictionnaireMapper() {
		// Nothing to do
	}

	/**
	 * @param lignesDictionnaireEntites
	 * @return List<LigneDictionnaire>
	 */
	public static List<LigneDictionnaire> transformerDictionnaireEntiteEnDictionnaire(List<LigneDictionnaireEntite> lignesDictionnaireEntites) {
		
		List<LigneDictionnaire> ligneDictionnaires = new ArrayList<>(); 

		for (LigneDictionnaireEntite dictionnaireEntite : lignesDictionnaireEntites) {
			LigneDictionnaire dictionnaire = new LigneDictionnaire(); 
			
			dictionnaire.setMot_fr(dictionnaireEntite.getDictionnairePk().getMot_fr());
			dictionnaire.setMot_com(dictionnaireEntite.getDictionnairePk().getMot_com());
			dictionnaire.setMot_ang(dictionnaireEntite.getMot_ang());
			dictionnaire.setMot_ndz(dictionnaireEntite.getMot_ndz());
			dictionnaire.setMot_mao(dictionnaireEntite.getMot_mao());
			dictionnaire.setMot_mwa(dictionnaireEntite.getMot_mwa());
			dictionnaire.setSuggestion(dictionnaireEntite.getSuggestion());
			dictionnaire.setDefinition_com(dictionnaireEntite.getDefinition_com());
			dictionnaire.setDefinition_fr(dictionnaireEntite.getDefinition_fr());
			
			ligneDictionnaires.add(dictionnaire);
			
		}
		
		return ligneDictionnaires; 
		
	}
}
