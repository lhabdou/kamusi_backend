package com.lh.kamusi.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.lh.kamusi.dao.entities.MotsUsersEntite;

public interface MotsUsersRepository  extends JpaRepository<MotsUsersEntite, Long> {
	
	
	
	@Query("select m from MotsUsersEntite m  where m.idUser = :uid")
	List <MotsUsersEntite> getMotsUsers(@Param("uid") String uid);
	
}
