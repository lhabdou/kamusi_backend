package com.lh.kamusi.metier.domain;

import java.io.Serializable;

public class RoleForm implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8530118873651228043L;

	private Integer id; 
	
	private String role;

	public RoleForm() {

	}
	
	
	public RoleForm(Integer id, String role) {
		super();
		this.id = id;
		this.role = role;
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	} 
	
	
	
}
