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

	@Id
	@Column(name="iduser")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="iduserarea")
	private long idUserArea;
	
	@Column(name="idorganization")
	private long idOrganization;
	
	@Column(name="idorganizationrol")
	private long idOrganizationRol;
	
	@Column(name="password")
	private String password;
	
	@Column(name="name")
	private String name;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="superuser")
	private String superuser;
	
	@Column(name="photo")
	private String photo;

	@Column(name="unavaibled")
	private String unavaibled;
	
	@Column(name="created_datetime")
	private String createdDatetime;
	
	@Column(name="created_platform")
	private String createdPlatform;
	
	@Column(name="updated_datetime")
	private String updatedDatetime;
	
	@Column(name="updated_platform")
	private String updatedPlatform;

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
	 * @return the idOrganization
	 */
	public long getIdOrganization() {
		return idOrganization;
	}

	/**
	 * @param idOrganization the idOrganization to set
	 */
	public void setIdOrganization(long idOrganization) {
		this.idOrganization = idOrganization;
	}

	/**
	 * @return the idOrganizationRol
	 */
	public long getIdOrganizationRol() {
		return idOrganizationRol;
	}

	/**
	 * @param idOrganizationRol the idOrganizationRol to set
	 */
	public void setIdOrganizationRol(long idOrganizationRol) {
		this.idOrganizationRol = idOrganizationRol;
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
	 * @return the firstName
	 */
	public String getLastname() {
		return lastName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the unavaibled
	 */
	public String getUnavaibled() {
		return unavaibled;
	}

	/**
	 * @param unavaibled the unavaibled to set
	 */
	public void setUnavaibled(String unavaibled) {
		this.unavaibled = unavaibled;
	}

	/**
	 * @return the createdDatetime
	 */
	public String getCreatedDatetime() {
		return createdDatetime;
	}

	/**
	 * @param createdDatetime the createdDatetime to set
	 */
	public void setCreatedDatetime(String createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	/**
	 * @return the createdPlatform
	 */
	public String getCreatedPlatform() {
		return createdPlatform;
	}

	/**
	 * @param createdPlatform the createdPlatform to set
	 */
	public void setCreatedPlatform(String createdPlatform) {
		this.createdPlatform = createdPlatform;
	}

	/**
	 * @return the updatedDatetime
	 */
	public String getUpdatedDatetime() {
		return updatedDatetime;
	}

	/**
	 * @param updatedDatetime the updatedDatetime to set
	 */
	public void setUpdatedDatetime(String updatedDatetime) {
		this.updatedDatetime = updatedDatetime;
	}

	/**
	 * @return the updatedPlatform
	 */
	public String getUpdatedPlatform() {
		return updatedPlatform;
	}

	/**
	 * @param updatedPlatform the updatedPlatform to set
	 */
	public void setUpdatedPlatform(String updatedPlatform) {
		this.updatedPlatform = updatedPlatform;
	}

	/**
	 * @param id
	 * @param idUserArea
	 * @param idOrganization
	 * @param idOrganizationRol
	 * @param password
	 * @param name
	 * @param lastName
	 * @param email
	 * @param superuser
	 * @param photo
	 * @param unavaibled
	 * @param createdDatetime
	 * @param createdPlatform
	 * @param updatedDatetime
	 * @param updatedPlatform
	 */
	public User(long id, long idUserArea, long idOrganization, long idOrganizationRol, String password, String name,
			String lastName, String email, String superuser, String photo, String unavaibled, String createdDatetime,
			String createdPlatform, String updatedDatetime, String updatedPlatform) {
		this.id = id;
		this.idUserArea = idUserArea;
		this.idOrganization = idOrganization;
		this.idOrganizationRol = idOrganizationRol;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.superuser = superuser;
		this.photo = photo;
		this.unavaibled = unavaibled;
		this.createdDatetime = createdDatetime;
		this.createdPlatform = createdPlatform;
		this.updatedDatetime = updatedDatetime;
		this.updatedPlatform = updatedPlatform;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", idUserArea=" + idUserArea + ", idOrganization=" + idOrganization
				+ ", idOrganizationRol=" + idOrganizationRol + ", password=" + password + ", name=" + name
				+ ", lastName=" + lastName + ", email=" + email + ", superuser=" + superuser + ", photo=" + photo
				+ ", unavaibled=" + unavaibled + ", createdDatetime=" + createdDatetime + ", createdPlatform="
				+ createdPlatform + ", updatedDatetime=" + updatedDatetime + ", updatedPlatform=" + updatedPlatform
				+ "]";
	}

}
