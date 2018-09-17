package com.lh.kamusi.metier.services;

import java.util.List;

import com.lh.kamusi.metier.domain.RoleForm;

public interface IRoleService {
	
	/**
	 * @return List<RoleForm>
	 */
	List<RoleForm> listerLesRoles(); 
	
	/**
	 * @param roleForm
	 */
	void supprimerUnRole(RoleForm roleForm); 
	
	/**
	 * @param roleForm
	 * @return
	 */
	RoleForm ajouterUnRole(RoleForm roleForm); 
	
	
	
	

}
