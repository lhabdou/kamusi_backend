/**
 * 
 */
package com.lh.kamusi.dao.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author asoilihi
 *
 */
@Entity
@Table(name="MotsUsers")
public class MotsUsersEntite implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 329105951351266848L;

	@Id
	@GenericGenerator(name="increment", strategy="increment")
	@GeneratedValue(generator="increment")
	@Column(name ="id")
	private Long id; 
	
	@Column(name = "mot")
	private String mot;
	
	@Column(name="id_user")
	private String idUser; 
	
	@Column(name="date_modification")
	private Date dateModification;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the mot
	 */
	public String getMot() {
		return mot;
	}

	/**
	 * @param mot the mot to set
	 */
	public void setMot(String mot) {
		this.mot = mot;
	}

	/**
	 * @return the idUser
	 */
	public String getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the dateModification
	 */
	public Date getDateModification() {
		return dateModification;
	}

	/**
	 * @param dateModification the dateModification to set
	 */
	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	} 
	

}
