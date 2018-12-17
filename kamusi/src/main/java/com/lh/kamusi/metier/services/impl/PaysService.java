/**
 * 
 */
package com.lh.kamusi.metier.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lh.kamusi.dao.repository.PaysRepository;
import com.lh.kamusi.metier.converter.PaysEntiteToPaysForm;
import com.lh.kamusi.metier.converter.PaysFormToPaysEntite;
import com.lh.kamusi.metier.domain.PaysForm;
import com.lh.kamusi.metier.services.IPaysService;

/**
 * @author asoilihi
 *
 */
@Service
public class PaysService implements IPaysService {

	@Autowired
	PaysRepository paysRepository;

	@Autowired
	PaysEntiteToPaysForm paysEntiteToPaysForm;

	@Autowired
	PaysFormToPaysEntite paysFormToPaysEntite;

	/**
	 * (non-Javadoc)
	 * 
	 * @see com.lh.kamusi.metier.services.IPaysService#listerLesPays()
	 */
	@Override
	public List<PaysForm> listerLesPays() {

		return paysEntiteToPaysForm.convertList(paysRepository.getAllCountry());
	}

}
