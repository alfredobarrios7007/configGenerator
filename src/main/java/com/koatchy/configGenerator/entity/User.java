/**
 * 
 */
package com.koatchy.configGenerator.entity;

/**
 * @author alfredo.barrios
 *
 */

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ctusers")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public User() {}
	
	

	/**
	 * @param id
	 * @param idUserArea
	 * @param password
	 * @param name
	 * @param email
	 * @param superuser
	 * @param unavaibled
	 */
	public User(long id, long idUserArea, String password, String name, String email, String superuser,
			String unavaibled) {
		this.id = id;
		this.idUserArea = idUserArea;
		this.password = password;
		this.name = name;
		this.email = email;
		this.superuser = superuser;
		this.unavaibled = unavaibled;
	}



	@Id
	@Column(name="iduser")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="iduserarea")
	private long idUserArea;
	
	@Column(name="password")
	private String password;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="superuser")
	private String superuser;
	
	@Column(name="unavaibled")
	private String unavaibled;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the idUserArea
	 */
	public long getIdUserArea() {
		return idUserArea;
	}

	/**
	 * @param idUserArea the idUserArea to set
	 */
	public void setIdUserArea(long idUserArea) {
		this.idUserArea = idUserArea;
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
		this.password = password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the superuser
	 */
	public String getSuperuser() {
		return superuser;
	}

	/**
	 * @param superuser the superuser to set
	 */
	public void setSuperuser(String superuser) {
		this.superuser = superuser;
	}

	/**
	 * @return the unavaible
	 */
	public String getUnavaibled() {
		return unavaibled;
	}

	/**
	 * @param unavaible the unavaible to set
	 */
	public void setUnavaibled(String unavaibled) {
		this.unavaibled = unavaibled;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", idUserArea=" + idUserArea + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", Superuser=" + superuser + ", unavaibled=" + unavaibled + "]";
	}	
	
}
