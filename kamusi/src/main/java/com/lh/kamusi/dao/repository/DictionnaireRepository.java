package com.lh.kamusi.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lh.kamusi.dao.entities.LigneDictionnaireEntite;
import com.lh.kamusi.dao.entities.pk.Dictionnaire_PK;

public interface DictionnaireRepository extends JpaRepository<LigneDictionnaireEntite, Dictionnaire_PK> {
	
	
	@Query("select d from LigneDictionnaireEntite d "
			+ "left join fetch d.utilisateur u "
			+ "left join fetch u.role "
			+ "where lower(mot_fr) LIKE CONCAT('%',:motCle,'%')") 
	List<LigneDictionnaireEntite> listerLesMots(@Param("motCle") String motCle);
	
	@Query("select d from LigneDictionnaireEntite d "
			+ "left join fetch d.utilisateur u "
			+ "left join fetch u.role "
			+ "where lower(mot_fr) = :motFr") 
	LigneDictionnaireEntite chercherAncienneLigne(@Param("motFr")String motFr); 
	
	
}
