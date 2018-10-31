package com.lh.kamusi.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lh.kamusi.metier.domain.PaysForm;
import com.lh.kamusi.metier.services.IPaysService;

@RestController
@CrossOrigin("http://localhost:8100")
@RequestMapping(value = "/kamusi", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PaysRestController {

	/**
	 * le service
	 */
	@Autowired
	private IPaysService paysService;

	/**
	 * Lister les pays
	 * 
	 * @param pay
	 * @return ResponseEntity<List<LigneDictionnaire>>
	 */
	@RequestMapping(value = "/pays", method = RequestMethod.GET)
	public ResponseEntity<List<PaysForm>> listerLesPaysRole() {

		return new ResponseEntity<>(paysService.listerLesPays(), HttpStatus.OK);

	}

}
