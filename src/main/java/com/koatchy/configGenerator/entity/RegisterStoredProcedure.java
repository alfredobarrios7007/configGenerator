/**
 * 
 */

  package com.koatchy.configGenerator.entity;
  
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.NamedStoredProcedureQueries; 
import javax.persistence.NamedStoredProcedureQuery; 
import javax.persistence.StoredProcedureParameter; 
import javax.persistence.ParameterMode; 
import javax.persistence.Id; 
import javax.persistence.Table;
  
 /**
	 * @author alfredo.barrios
	 *
	 */

@Entity
@Table(name = "nothinghill")
@NamedStoredProcedureQueries(
		{
			@NamedStoredProcedureQuery( 
					name = "register", procedureName = "REGISTER",
					resultClasses = {  
							RegisterStoredProcedure.class
							},
					parameters = {
				  @StoredProcedureParameter(name = "p_platform", type = String.class, mode = ParameterMode.IN),
				  @StoredProcedureParameter(name = "p_name", type = String.class, mode = ParameterMode.IN),
				  @StoredProcedureParameter(name = "p_lastname", type = String.class, mode = ParameterMode.IN),
				  @StoredProcedureParameter(name = "p_organization", type = String.class, mode = ParameterMode.IN),
				  @StoredProcedureParameter(name = "p_area", type = String.class, mode = ParameterMode.IN),
				  @StoredProcedureParameter(name = "p_email", type = String.class, mode = ParameterMode.IN),
				  @StoredProcedureParameter(name = "p_password", type = String.class, mode = ParameterMode.IN) 
				  }
  ) 
  }
) 
public class RegisterStoredProcedure implements Serializable {
  
	/**
	* 
	*/
	
	private static final long serialVersionUID = 1L;
	  
	public RegisterStoredProcedure() {
		  
	}
	  
	/**
	* "in" arguments
	*/
	@Id
	@Column(name = "iduser")
	private Long id; 
	  
	@Column(name = "iduserarea")
	private Long iduserarea; 
	  
	@Column(name = "userarea")
	private String userArea; 
	  
	@Column(name = "idorganization")
	private String idOrganization; 
	  
	@Column(name = "Organization")
	private String organization; 
	  
	@Column(name = "idorganizationrol")
	private Long idOrganizationRol; 
	  
	@Column(name = "organizationrol")
	private String organizationRol; 
	  
	@Column(name = "password")
	private String password;
	  
	@Column(name = "name")
	private String name;
	  
	@Column(name = "lastname")
	private String lastname;
	  
	@Column(name = "email")
	private String email;
	  
	@Column(name = "superuser")
	private String superuser;
	  
	@Column(name = "confirmed")
	private String confirmed;
	  
	@Column(name = "photo")
	private String photo;
	 
	@Column(name = "unavaibled")
	private String unavaibled;
	  
	@Column(name = "created_datetime")
	private String createdDatetime;
	  
	@Column(name = "created_platform")
	private String createdPlatform;
	  
	@Column(name = "updated_datetime")
	private String updatedDatetime;
	  
	@Column(name = "updated_platform")
	private String updatedPlatform;

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
	 * @return the iduserarea
	 */
	public Long getIduserarea() {
		return iduserarea;
	}

	/**
	 * @param iduserarea the iduserarea to set
	 */
	public void setIduserarea(Long iduserarea) {
		this.iduserarea = iduserarea;
	}

	/**
	 * @return the userArea
	 */
	public String getUserArea() {
		return userArea;
	}

	/**
	 * @param userArea the userArea to set
	 */
	public void setUserArea(String userArea) {
		this.userArea = userArea;
	}

	/**
	 * @return the idOrganization
	 */
	public String getIdOrganization() {
		return idOrganization;
	}

	/**
	 * @param idOrganization the idOrganization to set
	 */
	public void setIdOrganization(String idOrganization) {
		this.idOrganization = idOrganization;
	}

	/**
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * @param organization the organization to set
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	/**
	 * @return the idOrganizationRol
	 */
	public Long getIdOrganizationRol() {
		return idOrganizationRol;
	}

	/**
	 * @param idOrganizationRol the idOrganizationRol to set
	 */
	public void setIdOrganizationRol(Long idOrganizationRol) {
		this.idOrganizationRol = idOrganizationRol;
	}

	/**
	 * @return the organizationRol
	 */
	public String getOrganizationRol() {
		return organizationRol;
	}

	/**
	 * @param organizationRol the organizationRol to set
	 */
	public void setOrganizationRol(String organizationRol) {
		this.organizationRol = organizationRol;
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
	 * @return the firstname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	 * @param iduserarea
	 * @param userArea
	 * @param idOrganization
	 * @param organization
	 * @param idOrganizationRol
	 * @param organizationRol
	 * @param password
	 * @param name
	 * @param lastname
	 * @param email
	 * @param superuser
	 * @param confirmed
	 * @param photo
	 * @param unavaibled
	 * @param createdDatetime
	 * @param createdPlatform
	 * @param updatedDatetime
	 * @param updatedPlatform
	 */
	public RegisterStoredProcedure(Long id, Long iduserarea, String userArea, String idOrganization,
			String organization, Long idOrganizationRol, String organizationRol, String password, String name,
			String lastname, String email, String superuser, String confirmed, String photo, String unavaibled,
			String createdDatetime, String createdPlatform, String updatedDatetime, String updatedPlatform) {
		this.id = id;
		this.iduserarea = iduserarea;
		this.userArea = userArea;
		this.idOrganization = idOrganization;
		this.organization = organization;
		this.idOrganizationRol = idOrganizationRol;
		this.organizationRol = organizationRol;
		this.password = password;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.superuser = superuser;
		this.confirmed = confirmed;
		this.photo = photo;
		this.unavaibled = unavaibled;
		this.createdDatetime = createdDatetime;
		this.createdPlatform = createdPlatform;
		this.updatedDatetime = updatedDatetime;
		this.updatedPlatform = updatedPlatform;
	}

	@Override
	public String toString() {
		return "RegisterStoredProcedure [id=" + id + ", iduserarea=" + iduserarea + ", userArea=" + userArea
				+ ", idOrganization=" + idOrganization + ", organization=" + organization + ", idOrganizationRol="
				+ idOrganizationRol + ", organizationRol=" + organizationRol + ", password=" + password + ", name="
				+ name + ", lastname=" + lastname + ", email=" + email + ", superuser=" + superuser + ", confirmed="
				+ confirmed + ", photo=" + photo + ", unavaibled=" + unavaibled + ", createdDatetime=" + createdDatetime
				+ ", createdPlatform=" + createdPlatform + ", updatedDatetime=" + updatedDatetime + ", updatedPlatform="
				+ updatedPlatform + "]";
	}

	
  
}
		 