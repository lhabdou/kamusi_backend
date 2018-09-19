package com.lh.kamusi.metier.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lh.kamusi.dao.entities.StatutEntite;
import com.lh.kamusi.metier.domain.StatutForm;

@Component
public class StatutEntiteToStatutForm implements Converter<StatutEntite, StatutForm> {
	
	@Override
	public StatutForm convert(StatutEntite StatutEntite) {
		StatutForm StatutForm = new StatutForm(); 
		
		StatutForm.setIdStatut(StatutEntite.getId_statut());
		StatutForm.setStatut(StatutEntite.getStatut());
		
		return StatutForm;
	}
}
