package com.lh.kamusi.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lh.kamusi.metier.domain.RoleForm;
import com.lh.kamusi.metier.services.IRoleService;

@RestController
@RequestMapping(value = "/kamusi", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class RoleRestController {
	
	
	/**
	 * le service 
	 */
	@Autowired
	private IRoleService roleService;
	
	
	/**
	 * Lister les roles 
	 * 
	 * @param role
	 * @return ResponseEntity<List<LigneDictionnaire>>
	 */
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public ResponseEntity<List<RoleForm>> listerLesRolesRole() {
		
		return new ResponseEntity<>(roleService.listerLesRoles(), HttpStatus.OK); 
		
	}
	
	/**
	 * Ajouter un Role 
	 * 
	 * @param roleForm
	 * @return ResponseEntity<RoleForm>
	 */
	@RequestMapping(value = "/roles/nouveau", method = RequestMethod.POST)
	public ResponseEntity<RoleForm> ajouterUnRole(@RequestBody RoleForm roleForm) {
		
		return new ResponseEntity<>(roleService.ajouterUnRole(roleForm), HttpStatus.OK); 
		
	}
	
	/**
	 * Supprimer un role
	 * 
	 * @param roleForm
	 * @return ResponseEntity<RoleForm>
	 */
	@RequestMapping(value = "/roles/supprimer", method = RequestMethod.DELETE)
	public HttpStatus supprimerUnRole(@RequestBody RoleForm roleForm) {
		
		 roleService.supprimerUnRole(roleForm);
		 
		 return HttpStatus.OK;
		 
	}


}
