package com.lh.kamusi.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lh.kamusi.dao.entities.DictionnaireTempEntite;
import com.lh.kamusi.dao.entities.LigneDictionnaireEntite;

public interface DictionnaireTempRepository extends JpaRepository<LigneDictionnaireEntite, String> {
	
	
	@Query("select d from DictionnaireTempEntite d "
			+ "left join fetch d.utilisateur u "
			+ "join fetch d.statut s") 
	List<DictionnaireTempEntite> listerLesMots(); 
	
	
}
