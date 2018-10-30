/**
 * 
 */
package com.lh.kamusi.metier.services.impl.enumerateur;

/**
 * @author asoilihi
 *
 */
public enum RolesStatuts {

	ROLE_ADMIN(1, "ADMINISTRATEUR"), ROLE_VALIDEUR(2, "VALIDEUR"), ROLE_CONTRIBUTEUR(3, "CONTRIBUTEUR"),
	ROLE_INVITE(4, "INVITE"), STATUT_NOUVEAU(1, "NOUVEAU"), STATUT_AVALIDER(2, "A VALIDER"), STATUT_VALIDE(3, "VALIDE"),
	STATUT_CLOTURE(4, "CLOTURE");

	/**
	 * 
	 */
	private final Integer id;

	/**
	 * 
	 */
	private String value;

	/**
	 * @param id
	 * @param value
	 */
	private RolesStatuts(Integer id, String value) {
		
		this.id = id;
		this.value = value;

	}

	/**
	 * @return String
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @return Integer
	 */
	public Integer getId() {
		return id;
	}

}
