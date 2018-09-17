package com.lh.kamusi.metier.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lh.kamusi.dao.entities.UtilisateurEntite;
import com.lh.kamusi.metier.domain.UtilisateurForm;


@Component
public class UtilisateurEntiteToUtilisateurForm implements Converter<UtilisateurEntite, UtilisateurForm> {
	
	@Autowired
	RoleEntiteToRoleForm roleConvert;
	
	@Override
	public UtilisateurForm convert(UtilisateurEntite utilisateurEntite) {
		UtilisateurForm utilisateurForm = new UtilisateurForm(); 
		
		utilisateurForm.setId_utilisateur(utilisateurEntite.getId_utilisateur());
		utilisateurForm.setNom(utilisateurEntite.getNom());
		utilisateurForm.setPrenom(utilisateurEntite.getPrenom());
		utilisateurForm.setPseudo(utilisateurEntite.getPseudo());
		utilisateurForm.setEmail(utilisateurEntite.getEmail());
		utilisateurForm.setUrl_image(utilisateurEntite.getUrl_image());
		
		utilisateurForm.setRole(roleConvert.convert(utilisateurEntite.getRole()));
		
		return utilisateurForm;
	}
}
