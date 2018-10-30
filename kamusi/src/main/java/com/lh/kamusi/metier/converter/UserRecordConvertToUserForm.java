package com.lh.kamusi.metier.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.google.firebase.auth.UserRecord;
import com.lh.kamusi.metier.domain.RoleForm;
import com.lh.kamusi.metier.domain.UtilisateurForm;
import com.lh.kamusi.metier.services.impl.enumerateur.RolesStatuts;

@Component
public class UserRecordConvertToUserForm implements Converter<UserRecord, UtilisateurForm> {

	/**
	 * @param userIdFromUid
	 * @return UtilisateurForm
	 */
	@Override
	public UtilisateurForm convert (UserRecord userIdFromUid) {
	
		UtilisateurForm userForm = new UtilisateurForm();
	
		userForm.setEmail(userIdFromUid.getEmail());
		userForm.setIdUtilisateur(userIdFromUid.getUid());
		userForm.setNom(userIdFromUid.getDisplayName());
		userForm.setRole(new RoleForm(RolesStatuts.ROLE_CONTRIBUTEUR.getId(), RolesStatuts.ROLE_CONTRIBUTEUR.getValue()));
		userForm.setUrlImage(userIdFromUid.getPhotoUrl());
		userForm.setTel(userIdFromUid.getPhoneNumber());
		userForm.setGoogleConnect(true);
	
		return userForm;
	
	}

}