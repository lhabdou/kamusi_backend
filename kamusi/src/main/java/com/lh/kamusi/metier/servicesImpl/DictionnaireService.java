package com.lh.kamusi.metier.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.kamusi.dao.entities.LigneDictionnaireEntite;
import com.lh.kamusi.dao.repository.DictionnaireRepository;
import com.lh.kamusi.metier.domain.LigneDictionnaire;
import com.lh.kamusi.metier.mapper.DictionnaireMapper;
import com.lh.kamusi.metier.services.IDictionnaireServices;

@Service
public class DictionnaireService implements IDictionnaireServices {

	@Autowired
	private DictionnaireRepository dictionnaireRepository;

	@Override
	public List<LigneDictionnaire> listerLesmotsFr(String motCle) {
		
		List<LigneDictionnaireEntite> lignesDictionnaireEntites = dictionnaireRepository.listerLesMots(motCle);
		
		return DictionnaireMapper.transformerDictionnaireEntiteEnDictionnaire(lignesDictionnaireEntites);
	}

	@Override
	public LigneDictionnaire ajouterUneLigneDictionnaire(LigneDictionnaire ligneDictionnaire) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LigneDictionnaire validerUneLigneDictionnaire(LigneDictionnaire ligneDictionnaire) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerUneLigneDictionnaire(LigneDictionnaire ligneDictionnaire) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifierUneLigneDictionnaire(LigneDictionnaire ligneDictionnaire) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param dictionnaireRepository the dictionnaireRepository to set
	 */
	public void setDictionnaireRepository(DictionnaireRepository dictionnaireRepository) {
		this.dictionnaireRepository = dictionnaireRepository;
	}
	
	
	

}
