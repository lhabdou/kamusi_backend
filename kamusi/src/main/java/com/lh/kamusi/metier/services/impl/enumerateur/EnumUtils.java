/**
 * 
 */
package com.lh.kamusi.metier.services.impl.enumerateur;

/**
 * @author asoilihi
 *
 */
public enum EnumUtils {

	ROLE_ADMIN("Administrateur"), ROLE_VALIDEUR("Valideur"), ROLE_CONTRIBUTEUR("Contributeur"),
	STATUT_NOUVEAU("Nouveau"), STATUT_AVALIDER("A valider"), STATUT_VALIDE("Validé");

	private String value;

	EnumUtils(String value) {

	}

	public String getValue() {
		return value;
	}

}
