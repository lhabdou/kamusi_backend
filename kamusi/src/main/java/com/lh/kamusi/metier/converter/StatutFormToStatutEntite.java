package com.lh.kamusi.metier.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lh.kamusi.dao.entities.StatutEntite;
import com.lh.kamusi.metier.domain.StatutForm;

@Component
public class StatutFormToStatutEntite implements Converter<StatutForm, StatutEntite> {
	
	@Override
	public StatutEntite convert(StatutForm StatutForm) {
		StatutEntite StatutEntite = new StatutEntite(); 
		
		StatutEntite.setId_statut(StatutForm.getId_statut());
		StatutEntite.setStatut(StatutForm.getStatut());
		
		return StatutEntite;
	}
}
