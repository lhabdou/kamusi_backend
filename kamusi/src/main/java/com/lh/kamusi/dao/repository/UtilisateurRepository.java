package com.lh.kamusi.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lh.kamusi.dao.entities.UtilisateurEntite;

public interface UtilisateurRepository extends JpaRepository<UtilisateurEntite, Long> {
	
	
	@Query("Select u from UtilisateurEntite u where lower(u.role.nom_role) = :role")
	List<UtilisateurEntite> listerLesUtilisateursRole(@Param("role")String role);
	
	

}
