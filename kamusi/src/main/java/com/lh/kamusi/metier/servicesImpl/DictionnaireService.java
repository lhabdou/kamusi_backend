package com.lh.kamusi.metier.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.kamusi.dao.entities.LigneDictionnaireEntite;
import com.lh.kamusi.dao.repository.DictionnaireRepository;
import com.lh.kamusi.metier.converter.LigneDictionnaireEntiteToLigneDictionnaireForm;
import com.lh.kamusi.metier.domain.LigneDictionnaireForm;
import com.lh.kamusi.metier.services.IDictionnaireServices;

@Service
public class DictionnaireService implements IDictionnaireServices {


	private DictionnaireRepository dictionnaireRepository;
	
	private LigneDictionnaireEntiteToLigneDictionnaireForm ligneDictEntiteToLigneDictForm;
	
	
	
	@Autowired
	public DictionnaireService (DictionnaireRepository dictionnaireRepository, LigneDictionnaireEntiteToLigneDictionnaireForm ligneDictEntiteToLigneDictForm) {
		
		this.dictionnaireRepository = dictionnaireRepository; 
		this.ligneDictEntiteToLigneDictForm = ligneDictEntiteToLigneDictForm; 
		
	}

	@Override
	public List<LigneDictionnaireForm> listerLesmotsFr(String motCle) {
		
		List<LigneDictionnaireEntite> lignesDictionnaireEntites = dictionnaireRepository.listerLesMots(motCle.toLowerCase());
		
		List<LigneDictionnaireForm> ligneDictionnaireForms = new ArrayList<>();
		
		for (LigneDictionnaireEntite ligneDictionnaireE : lignesDictionnaireEntites) {
			
			ligneDictionnaireForms.add(ligneDictEntiteToLigneDictForm.convert(ligneDictionnaireE));
			
		}		
		
		return ligneDictionnaireForms;
	}

	@Override
	public LigneDictionnaireForm ajouterUneLigneDictionnaire(LigneDictionnaireForm ligneDictionnaire) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LigneDictionnaireForm validerUneLigneDictionnaire(LigneDictionnaireForm ligneDictionnaire) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerUneLigneDictionnaire(LigneDictionnaireForm ligneDictionnaire) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifierUneLigneDictionnaire(LigneDictionnaireForm ligneDictionnaire) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param dictionnaireRepository the dictionnaireRepository to set
	 */
	public void setDictionnaireRepository(DictionnaireRepository dictionnaireRepository) {
		this.dictionnaireRepository = dictionnaireRepository;
	}
	
	
	

}
