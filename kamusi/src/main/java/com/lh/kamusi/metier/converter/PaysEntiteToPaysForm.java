package com.lh.kamusi.metier.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lh.kamusi.dao.entities.PaysEntite;
import com.lh.kamusi.metier.domain.PaysForm;

@Component
public class PaysEntiteToPaysForm implements Converter<PaysEntite, PaysForm> {

	@Override
	public PaysForm convert(PaysEntite paysEntite) {
		PaysForm paysForm = new PaysForm();

		paysForm.setCode(paysEntite.getCode());
		paysForm.setNom(paysEntite.getNom());

		return paysForm;
	}

	/**
	 * @param listePaysEntite
	 * @return List<PaysForm>
	 */
	public List<PaysForm> convertList(List<PaysEntite> listePaysEntite) {

		List<PaysForm> listePaysForm = new ArrayList<>();

		for (PaysEntite paysEntite : listePaysEntite) {

			listePaysForm.add(convert(paysEntite));
		}

		return listePaysForm;

	}
}
