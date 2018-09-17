package com.lh.kamusi.metier.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lh.kamusi.dao.entities.RoleEntite;
import com.lh.kamusi.metier.domain.RoleForm;

@Component
public class RoleFormToRoleEntite implements Converter<RoleForm, RoleEntite> {
	
	@Override
	public RoleEntite convert(RoleForm roleForm) {
		RoleEntite roleEntite = new RoleEntite(); 
		
		roleEntite.setId(roleForm.getId());
		roleEntite.setNom_role(roleForm.getRole());
		
		return roleEntite;
	}
}
