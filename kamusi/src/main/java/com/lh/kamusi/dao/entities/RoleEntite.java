package com.lh.kamusi.dao.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Roles")
public class RoleEntite implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1840988826663197404L;

	@Id
	@GeneratedValue
	@Column(name ="id")
    private Integer id;

    @Column(name = "nom_role")
    private String nom_role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom_role() {
		return nom_role;
	}

	public void setNom_role(String nom_role) {
		this.nom_role = nom_role;
	}


}
