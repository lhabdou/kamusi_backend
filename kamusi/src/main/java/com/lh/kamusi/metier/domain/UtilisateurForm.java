/**
 * 
 */
package com.lh.kamusi.metier.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.lh.kamusi.rest.CryptPW.BCryptManagerUtil;

/**
 * @author asoilihi
 *
 */
public class UtilisateurForm implements UserDetails {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4084592835867732823L;

	private String idUtilisateur;

	private String nom;

	private String prenom;

	private String pseudo;

	private String tel;
	
	private String email;
	
	private Boolean emailVerifie;
	
	private String password;
	
	private PaysForm pays;
	
	private boolean googleConnect;

	private String urlImage;

	private RoleForm role;

	/**
	 * @return the id_utilisateur
	 */
	public String getIdUtilisateur() {
		return idUtilisateur;
	}

	/**
	 * @param id_utilisateur the id_utilisateur to set
	 */
	public void setIdUtilisateur(String string) {
		this.idUtilisateur = string;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the urlImage
	 */
	public String getUrlImage() {
		return urlImage;
	}

	/**
	 * @param urlImage the urlImage to set
	 */
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	/**
	 * @return the role
	 */
	public RoleForm getRole() {
		return role;
	}
	
	/**
	 * @return the roles
	 */
	public List<RoleForm> getRoles() {
		
		return Arrays.asList(getRole());
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(RoleForm role) {
		this.role = role;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the googleConnect
	 */
	public boolean isGoogleConnect() {
		return googleConnect;
	}

	/**
	 * @param googleConnect the googleConnect to set
	 */
	public void setGoogleConnect(boolean googleConnect) {
		this.googleConnect = googleConnect;
	}

	/**
	 * @return the pays
	 */
	public PaysForm getPays() {
		return pays;
	}

	/**
	 * @param pays the pays to set
	 */
	public void setPays(PaysForm pays) {
		this.pays = pays;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		if (!password.isEmpty()) {
            this.password = BCryptManagerUtil.passwordencoder().encode(password);
        }
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.commaSeparatedStringToAuthorityList(this.role.getRole());
	}

	@Override
	public String getUsername() {
		
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

	/**
	 * @return the emailVerifie
	 */
	public Boolean getEmailVerifie() {
		return emailVerifie;
	}

	/**
	 * @param emailVerifie the emailVerifie to set
	 */
	public void setEmailVerifie(Boolean emailVerifie) {
		this.emailVerifie = emailVerifie;
	}
	
	
	
}
