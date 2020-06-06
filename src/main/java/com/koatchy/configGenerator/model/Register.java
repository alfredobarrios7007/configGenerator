package com.koatchy.configGenerator.model;

import java.io.Serializable;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author alfredo.barrios
 *
 */
@Component
@Scope(value="prototype")
public class Register implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	private long idUserArea;
	private long idCompany;
	private String companyName; //In case of a new company
	private String userAreaName; //In case of a new user area
	private String password;
	private String name;
	private String email;
	private String superuser;
	private String unavaibled;
	private String createdDatetime;
	private String createdPlatform;
	private String updatedDatetime;
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
	 * @return the idCompany
	 */
	public long getIdCompany() {
		return idCompany;
	}
	/**
	 * @param idCompany the idCompany to set
	 */
	public void setIdCompany(long idCompany) {
		this.idCompany = idCompany;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the userAreaName
	 */
	public String getUserAreaName() {
		return userAreaName;
	}
	/**
	 * @param userAreaName the userAreaName to set
	 */
	public void setUserAreaName(String userAreaName) {
		this.userAreaName = userAreaName;
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
	 * @param idCompany
	 * @param companyName
	 * @param userAreaName
	 * @param password
	 * @param name
	 * @param email
	 * @param superuser
	 * @param unavaibled
	 * @param createdDatetime
	 * @param createdPlatform
	 * @param updatedDatetime
	 * @param updatedPlatform
	 */
	public Register(long id, long idUserArea, long idCompany, String companyName, String userAreaName, String password,
			String name, String email, String superuser, String unavaibled, String createdDatetime,
			String createdPlatform, String updatedDatetime, String updatedPlatform) {
		this.id = id;
		this.idUserArea = idUserArea;
		this.idCompany = idCompany;
		this.companyName = companyName;
		this.userAreaName = userAreaName;
		this.password = password;
		this.name = name;
		this.email = email;
		this.superuser = superuser;
		this.unavaibled = unavaibled;
		this.createdDatetime = createdDatetime;
		this.createdPlatform = createdPlatform;
		this.updatedDatetime = updatedDatetime;
		this.updatedPlatform = updatedPlatform;
	}
	
	@Override
	public String toString() {
		return "Register [id=" + id + ", idUserArea=" + idUserArea + ", idCompany=" + idCompany + ", companyName="
				+ companyName + ", userAreaName=" + userAreaName + ", password=" + password + ", name=" + name
				+ ", email=" + email + ", superuser=" + superuser + ", unavaibled=" + unavaibled + ", createdDatetime="
				+ createdDatetime + ", createdPlatform=" + createdPlatform + ", updatedDatetime=" + updatedDatetime
				+ ", updatedPlatform=" + updatedPlatform + "]";
	}	
	
}
