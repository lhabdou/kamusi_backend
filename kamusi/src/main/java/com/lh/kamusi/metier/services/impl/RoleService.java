/**
 * 
 */
package com.lh.kamusi.metier.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.kamusi.dao.repository.RoleRepository;
import com.lh.kamusi.metier.converter.RoleEntiteToRoleForm;
import com.lh.kamusi.metier.converter.RoleFormToRoleEntite;
import com.lh.kamusi.metier.domain.RoleForm;
import com.lh.kamusi.metier.services.IRoleService;

/**
 * @author asoilihi
 *
 */
@Service
public class RoleService implements IRoleService {

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	RoleEntiteToRoleForm roleEntiteToRoleForm;

	@Autowired
	RoleFormToRoleEntite roleFormToRoleEntite;

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.lh.kamusi.metier.services.IRoleService#listerLesRoles()
	 */
	@Override
	public List<RoleForm> listerLesRoles() {

		return roleEntiteToRoleForm.convertList(roleRepository.findAll());
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.lh.kamusi.metier.services.IRoleService#
	 *      supprimerUnRole(com.lh.kamusi.metier.domain.RoleForm)
	 */
	@Override
	public void supprimerUnRole(RoleForm roleForm) {

		roleRepository.delete(roleFormToRoleEntite.convert(roleForm));

	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.lh.kamusi.metier.services.IRoleService#
	 *      ajouterUnRole(com.lh.kamusi.metier.domain.RoleForm)
	 */
	@Override
	public RoleForm ajouterUnRole(RoleForm roleForm) {

		return roleEntiteToRoleForm.convert(roleRepository.saveAndFlush(roleFormToRoleEntite.convert(roleForm)));
	}

}
