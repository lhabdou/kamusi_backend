package com.lh.kamusi.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lh.kamusi.dao.entities.DictionnaireTempEntite;

public interface DictionnaireTempRepository extends JpaRepository<DictionnaireTempEntite, String> {
	
	
	@Query("select d from DictionnaireTempEntite d "
			+ "left join fetch d.utilisateur u "
			+ "join fetch d.statut s "
			+ "where d.dialectModifie =:dialect") 
	List<DictionnaireTempEntite> listerLesMots(@Param("dialect") String dialect); 
	
	
}
