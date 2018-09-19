/**
 * 
 */
package com.lh.kamusi.metier.services.impl.enumerateur;

/**
 * @author asoilihi
 *
 */
public enum EnumUtils {

	ROLE_ADMIN(1,"ADMINISTRATEUR"), ROLE_VALIDEUR(2,"VALIDEUR"), ROLE_CONTRIBUTEUR(3, "CONTRIBUTEUR"), ROLE_INVITE(4, "INVITE"),
	STATUT_NOUVEAU(1,"NOUVEAU"), STATUT_AVALIDER(2, "A VALIDER"), STATUT_VALIDE(3, "VALIDE"), STATUT_CLOTURE(4, "CLOTURE");

	private String value;
	
	private Integer id; 
	
	EnumUtils(Integer id, String value) {

	}

	public String getValue() {
		return value;
	}
	
	public Integer getId() {
		return id;
	}


}
