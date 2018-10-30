package com.lh.kamusi.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lh.kamusi.dao.entities.UtilisateurEntite;

public interface UtilisateurRepository extends JpaRepository<UtilisateurEntite, String> {
	
	
	@Query("Select u from UtilisateurEntite u "
			+ "inner join fetch u.role "
			+ "where upper(u.role.nom_role) = :role")
	List<UtilisateurEntite> listerLesUtilisateursRole(@Param("role")String role);

	@Query("Select u from UtilisateurEntite u "
			+ "inner join fetch u.role "
			+ "where upper(u.role.nom_role) = 'ADMINISTRATEUR'") 
	UtilisateurEntite getAdminUser();

	@Query("Select u from UtilisateurEntite u "
			+ "inner join fetch u.role "
			+ "where u.idUtilisateur = :uid")
	UtilisateurEntite getUserIfExist(@Param("uid") String uid);
	

}
