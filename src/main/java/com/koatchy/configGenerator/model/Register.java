package com.koatchy.configGenerator.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author alfredo.barrios
 *
 */
@Component
@Scope(value="prototype")
public class Register extends GeneralRequest {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	private String lastname;
	private String organization;
	private String area;
	private String email;
	private String password;

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
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	 * @return the area
	 */
	public String getArea() {
		return area;
	}
	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
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
	 * @param platform
	 * @param name
	 * @param lastname
	 * @param organization
	 * @param area
	 * @param email
	 * @param password
	 */
	public Register(long id, String platform, String name, String lastname, String organization, String area, String email,
			String password, String caller) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.organization = organization;
		this.area = area;
		this.email = email;
		this.password = password;
		super.setCaller(caller);
		super.setPlatform(platform);
	}

	@Override
	public String toString() {
		return "Register [id=" + id + ", name=" + name + ", lastname=" + lastname
				+ ", organization=" + organization + ", area=" + area + ", email=" + email + ", password=" + password
				+ "Platform: " + super.getPlatform() + ", Caller: " + super.getCaller() + "]";
	}	

}
