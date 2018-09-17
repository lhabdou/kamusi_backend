package com.lh.kamusi.metier.services;

import java.util.List;

import com.lh.kamusi.metier.domain.StatutForm;

public interface IStatutService {
	
	/**
	 * @return List<RoleForm>
	 */
	List<StatutForm> listerLesStatuts(); 
	
	/**
	 * @param statutForm
	 */
	void supprimerUnStatut(StatutForm statutForm); 
	
	/**
	 * @param statutForm
	 * @return StatutForm
	 */
	StatutForm ajouterUnStatut(StatutForm statutForm); 

}
