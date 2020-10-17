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
	private Long id;
	
	@Column(name="iduserarea",nullable = true)
	private Long idUserArea;
	
	@Column(name="idorganization",nullable = true)
	private Long idOrganization;
	
	@Column(name="idorganizationrole",nullable = true)
	private Long idOrganizationRole;
	
	@Column(name="password")
	private String password;
	
	@Column(name="name")
	private String name;
	
	@Column(name="lastname",nullable = true)
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="superuser")
	private String superuser;
	
	@Column(name="confirmed")
	private String confirmed;
	
	@Column(name="photo",nullable = true)
	private String photo;

	@Column(name="enabled")
	private String enabled;
	
	@Column(name="created_datetime",nullable = false)
	private String createdDatetime;
	
	@Column(name="created_platform",nullable = false)
	private String createdPlatform;
	
	@Column(name="updated_datetime",nullable = true)
	private String updatedDatetime;
	
	@Column(name="updated_platform",nullable = true)
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
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the idUserArea
	 */
	public Long getIdUserArea() {
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
	 * @return the idOrganizationRole
	 */
	public long getIdOrganizationRole() {
		return idOrganizationRole;
	}

	/**
	 * @param idOrganizationRole the idOrganizationRole to set
	 */
	public void setIdOrganizationRole(long idOrganizationRole) {
		this.idOrganizationRole = idOrganizationRole;
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
	 * @return the enabled
	 */
	public String getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabledto set
	 */
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the confirmed
	 */
	public String getConfirmed() {
		return confirmed;
	}

	/**
	 * @param confirmed the confirmed to set
	 */
	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
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
	 * @param idOrganizationRole
	 * @param password
	 * @param name
	 * @param lastName
	 * @param email
	 * @param superuser
	 * @param photo
	 * @param enabled
	 * @param createdDatetime
	 * @param createdPlatform
	 * @param updatedDatetime
	 * @param updatedPlatform
	 */
	public User(long id, long idUserArea, long idOrganization, long idOrganizationRole, String password, String name,
			String lastName, String email, String superuser, String photo, String enabled, String createdDatetime,
			String createdPlatform, String updatedDatetime, String updatedPlatform) {
		this.id = id;
		this.idUserArea = idUserArea;
		this.idOrganization = idOrganization;
		this.idOrganizationRole = idOrganizationRole;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.superuser = superuser;
		this.photo = photo;
		this.enabled = enabled;
		this.createdDatetime = createdDatetime;
		this.createdPlatform = createdPlatform;
		this.updatedDatetime = updatedDatetime;
		this.updatedPlatform = updatedPlatform;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", idUserArea=" + idUserArea + ", idOrganization=" + idOrganization
				+ ", idOrganizationRole=" + idOrganizationRole + ", password=" + password + ", name=" + name
				+ ", lastName=" + lastName + ", email=" + email + ", superuser=" + superuser + ", photo=" + photo
				+ ", enabled=" + enabled + ", createdDatetime=" + createdDatetime + ", createdPlatform="
				+ createdPlatform + ", updatedDatetime=" + updatedDatetime + ", updatedPlatform=" + updatedPlatform
				+ "]";
	}

}
