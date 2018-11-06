package com.lh.kamusi.metier.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lh.kamusi.dao.entities.PaysEntite;
import com.lh.kamusi.metier.domain.PaysForm;

@Component
public class PaysFormToPaysEntite implements Converter<PaysForm, PaysEntite> {

	@Override
	public PaysEntite convert(PaysForm paysForm) {
		PaysEntite paysEntite = new PaysEntite();

		paysEntite.setCode(paysForm.getCode());
		paysEntite.setNom(paysForm.getNom());

		return paysEntite;
	}

	
}
