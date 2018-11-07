package com.lh.kamusi.rest.handler;

import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	
	/**
	 * Constante pour le message ERREUR_INTERNE_SERVEUR
	 */
	private static final String ERREUR_INTERNE_SERVEUR = "Erreur interne au serveur";

	/**
	 * Constante pour le message ERREUR_METIER
	 */
	private static final String ERREUR_METIER = "Erreur métier";


	/**
	 * Methode formattant un message JSon pour une runtime exception levée
	 * 
	 * @param ex
	 *            l'exception runtime lancée
	 * @param request
	 *            la requête http
	 * @return ResponseEntity<Objet>
	 */
	@ExceptionHandler(value = { RuntimeException.class })
	protected ResponseEntity<Object> handleRuntimeException(Exception ex, WebRequest request) {
		return handleExceptionInternal(ex,
				formaterMessageErreur(HttpStatus.INTERNAL_SERVER_ERROR, ERREUR_INTERNE_SERVEUR, ex), new HttpHeaders(),
				HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
	
	/**
	 * Methode formattant un message JSon pour une AccessDeniedException levée
	 * 
	 * @param ex
	 *            l'exception runtime lancée
	 * @param request
	 *            la requête http
	 * @return ResponseEntity<Objet>
	 */
	@ExceptionHandler(value = { AccessDeniedException.class })
	protected ResponseEntity<Object> handleAccessDeniedException(Exception ex, WebRequest request) {
		return handleExceptionInternal(ex,
				new Erreur(HttpStatus.UNAUTHORIZED.value(),"Accès refusé, vous n’avez pas l'autorisation d'accéder à ce service", ERREUR_METIER), new HttpHeaders(),
				HttpStatus.UNAUTHORIZED, request);
	}

	/**
	 * Méthode pour formatter le message d'erreur
	 * 
	 * @param statutHttp
	 *            le statut http
	 * @param libelleErreur
	 *            le libellé de l'erreur
	 * @param exception
	 *            l'exception levée
	 * @return Erreur l'objet erreur formaté
	 */
	private Erreur formaterMessageErreur(HttpStatus statutHttp, String libelleErreur, Exception exception) {
		StringBuilder localisationErreur = new StringBuilder();
		localisationErreur.append(exception.getStackTrace()[0].getMethodName());
		localisationErreur.append(exception.getStackTrace()[0].getClassName());
		localisationErreur.append(", ligne: ");
		localisationErreur.append(exception.getStackTrace()[0].getLineNumber());
		return new Erreur(statutHttp.value(), libelleErreur, localisationErreur.toString());
	}
}
