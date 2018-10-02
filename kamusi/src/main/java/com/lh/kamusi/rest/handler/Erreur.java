package com.lh.kamusi.rest.handler;

import java.io.Serializable;

public class Erreur implements Serializable {

	/**
	 * Le numéro de version
	 */
	private static final long serialVersionUID = -8742057054234418898L;

	/**
	 * Le code de l'erreur
	 */
	private int codeErreur;

	/**
	 * Le libelle de l'erreur
	 */
	private String message;

	/**
	 * Le message de l'erreur
	 */
	private String exception;

	public Erreur(int codeErreur, String message, String exception) {
		this.codeErreur = codeErreur;
		this.message = message;
		this.exception = exception;
	}

	/**
	 * @return the codeErreur
	 */
	public int getCodeErreur() {
		return codeErreur;
	}

	/**
	 * @param codeErreur
	 *            the codeErreur to set
	 */
	public void setCodeErreur(int codeErreur) {
		this.codeErreur = codeErreur;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the exception
	 */
	public String getException() {
		return exception;
	}

	/**
	 * @param exception
	 *            the exception to set
	 */
	public void setException(String exception) {
		this.exception = exception;
	}

	/**
	 * {@inheritDoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Code erreur : ");
		stringBuilder.append(codeErreur);
		stringBuilder.append(" | ");
		stringBuilder.append("Libelle erreur : ");
		stringBuilder.append(message);
		stringBuilder.append(" | ");
		stringBuilder.append("Message erreur : ");
		stringBuilder.append(exception);
		return stringBuilder.toString();
	}
}
