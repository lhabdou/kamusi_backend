package com.lh.kamusi.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lh.kamusi.dao.entities.LigneDictionnaireEntite;
import com.lh.kamusi.dao.entities.pk.DictionnairePk;

public interface DictionnaireRepository extends JpaRepository<LigneDictionnaireEntite, DictionnairePk> {
	
	
	@Query("select d from LigneDictionnaireEntite d "
			+ "inner join fetch d.utilisateur u "
			+ "inner join fetch u.role "
			+ "inner join fetch d.statut "
			+ "where lower(mot_fr) LIKE CONCAT('%',:motCle,'%')") 
	List<LigneDictionnaireEntite> listerLesMotsFr (@Param("motCle") String motCle);
	
	@Query("select d from LigneDictionnaireEntite d "
			+ "inner join fetch d.utilisateur u "
			+ "inner join fetch u.role "
			+ "inner join fetch d.statut "
			+ "where lower(mot_ngz) LIKE CONCAT('%',:motCle,'%')") 
	List<LigneDictionnaireEntite> listerLesMotsNgz (@Param("motCle") String motCle);
	
	@Query("select d from LigneDictionnaireEntite d "
			+ "inner join fetch d.utilisateur u "
			+ "inner join fetch u.role "
			+ "inner join fetch d.statut "
			+ "where lower(mot_ang) LIKE CONCAT('%',:motCle,'%')") 
	List<LigneDictionnaireEntite> listerLesMotsAng (@Param("motCle") String motCle);
	
	@Query("select d from LigneDictionnaireEntite d "
			+ "inner join fetch d.utilisateur u "
			+ "inner join fetch u.role "
			+ "inner join fetch d.statut "
			+ "where lower(mot_fr) = :motFr") 
	LigneDictionnaireEntite chercherAncienneLigne (@Param("motFr") String motFr);

	@Query("select d from LigneDictionnaireEntite d "
			+ "inner join fetch d.utilisateur u "
			+ "inner join fetch u.role "
			+ "where lower(u.idUtilisateur) = :uid") 
	List<LigneDictionnaireEntite> listerLesMotsParUserId (@Param("uid") String uid); 
	
	
}
