package com.lh.kamusi.metier.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lh.kamusi.dao.entities.UtilisateurEntite;
import com.lh.kamusi.metier.domain.UtilisateurForm;


@Component
public class UtilisateurFormToUtilisateurEntite implements Converter<UtilisateurForm, UtilisateurEntite> {
	
	@Autowired
	RoleFormToRoleEntite roleConvert;
	
	@Override
	public UtilisateurEntite convert(UtilisateurForm utilisateurForm) {
		UtilisateurEntite utilisateurEntite = new UtilisateurEntite(); 
		
		utilisateurEntite.setId_utilisateur(utilisateurForm.getId_utilisateur());
		utilisateurEntite.setNom(utilisateurForm.getNom());
		utilisateurEntite.setPrenom(utilisateurForm.getPrenom());
		utilisateurEntite.setPseudo(utilisateurForm.getPseudo());
		utilisateurEntite.setEmail(utilisateurForm.getEmail());
		utilisateurEntite.setUrl_image(utilisateurForm.getUrl_image());
		
		utilisateurEntite.setRole(roleConvert.convert(utilisateurForm.getRole()));
		
		return utilisateurEntite;
	}
}
