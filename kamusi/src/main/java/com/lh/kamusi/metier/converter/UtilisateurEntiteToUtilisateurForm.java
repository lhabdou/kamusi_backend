package com.lh.kamusi.metier.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lh.kamusi.dao.entities.UtilisateurEntite;
import com.lh.kamusi.metier.domain.UtilisateurForm;

@Component
public class UtilisateurEntiteToUtilisateurForm implements Converter<UtilisateurEntite, UtilisateurForm> {

	@Autowired
	RoleEntiteToRoleForm roleConvert;

	/**
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public UtilisateurForm convert(UtilisateurEntite utilisateurEntite) {

		UtilisateurForm utilisateurForm = null;

		if (utilisateurEntite != null && utilisateurEntite.getIdUtilisateur() != null) {
			utilisateurForm = new UtilisateurForm();
			utilisateurForm.setIdUtilisateur(utilisateurEntite.getIdUtilisateur());
			utilisateurForm.setNom(utilisateurEntite.getNom());
			utilisateurForm.setPrenom(utilisateurEntite.getPrenom());
			utilisateurForm.setPseudo(utilisateurEntite.getPseudo());
			utilisateurForm.setEmail(utilisateurEntite.getEmail());
			utilisateurForm.setUrlImage(utilisateurEntite.getUrlImage());
			utilisateurForm.setTel(utilisateurEntite.getTel());
			utilisateurForm.setGoogleConnect(utilisateurEntite.isGoogleConnect());

			utilisateurForm.setRole(roleConvert.convert(utilisateurEntite.getRole()));
		}

		return utilisateurForm;
	}

	/**
	 * @param listEntite
	 * @return List<UtilisateurForm>
	 */
	public List<UtilisateurForm> convertList(List<UtilisateurEntite> listEntite) {
		List<UtilisateurForm> utilisateurForms = new ArrayList<>();

		for (UtilisateurEntite entite : listEntite) {
			utilisateurForms.add(convert(entite));
		}
		return utilisateurForms;
	}
}
