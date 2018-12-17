package com.lh.kamusi.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lh.kamusi.dao.entities.PaysEntite;

public interface PaysRepository extends JpaRepository<PaysEntite, String> {
	@Query("select p from PaysEntite p order by p.nom")
	List<PaysEntite> getAllCountry();

}
