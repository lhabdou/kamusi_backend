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
	@Autowired
	PaysFormToPaysEntite paysConvert;

	
	@Override
	public UtilisateurEntite convert(UtilisateurForm utilisateurForm) {
		UtilisateurEntite utilisateurEntite = new UtilisateurEntite(); 
		
		utilisateurEntite.setIdUtilisateur(utilisateurForm.getIdUtilisateur());
		utilisateurEntite.setNom(utilisateurForm.getNom());
		utilisateurEntite.setPrenom(utilisateurForm.getPrenom());
		utilisateurEntite.setPseudo(utilisateurForm.getPseudo());
		utilisateurEntite.setEmail(utilisateurForm.getEmail());
		utilisateurEntite.setUrlImage(utilisateurForm.getUrlImage());
		utilisateurEntite.setTel(utilisateurForm.getTel());
		utilisateurEntite.setGoogleConnect(utilisateurForm.isGoogleConnect());
		
		utilisateurEntite.setRole(roleConvert.convert(utilisateurForm.getRole()));
		
		if(utilisateurForm.getPays() != null) {
			
			utilisateurEntite.setPays(paysConvert.convert(utilisateurForm.getPays()));
		}
		
		return utilisateurEntite;
	}
}
