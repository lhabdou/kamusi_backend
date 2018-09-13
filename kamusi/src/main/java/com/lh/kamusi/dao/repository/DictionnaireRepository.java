package com.lh.kamusi.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lh.kamusi.dao.entities.LigneDictionnaireEntite;

public interface DictionnaireRepository extends JpaRepository<LigneDictionnaireEntite, String> {
	
	
	@Query("select * from LigneDictionnaire where mot_fr like %:motCle%") 
	List<LigneDictionnaireEntite> listerLesMots(@Param("motCle") String motCle); 
	
	
}
