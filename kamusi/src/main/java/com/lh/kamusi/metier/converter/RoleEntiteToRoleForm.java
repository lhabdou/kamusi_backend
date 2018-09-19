package com.lh.kamusi.metier.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lh.kamusi.dao.entities.RoleEntite;
import com.lh.kamusi.metier.domain.RoleForm;

@Component
public class RoleEntiteToRoleForm implements Converter<RoleEntite, RoleForm> {

	@Override
	public RoleForm convert(RoleEntite roleEntite) {
		RoleForm roleForm = new RoleForm();

		roleForm.setId(roleEntite.getId());
		roleForm.setRole(roleEntite.getNom_role());

		return roleForm;
	}

	/**
	 * @param listeRoleEntite
	 * @return List<RoleForm>
	 */
	public List<RoleForm> convertList(List<RoleEntite> listeRoleEntite) {

		List<RoleForm> listeRoleForm = new ArrayList<>();

		for (RoleEntite roleEntite : listeRoleEntite) {

			listeRoleForm.add(convert(roleEntite));
		}

		return listeRoleForm;

	}
}
