package com.koatchy.configGenerator.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

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
	private MultipartFile photo;

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
	 * @return the photo
	 */
	public MultipartFile getPhoto() {
		return photo;
	}
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}

	public Register() {}
	
	/**
	 * @param id
	 * @param name
	 * @param lastname
	 * @param organization
	 * @param area
	 * @param email
	 * @param password
	 * @param platform
	 * @param caller
	 * @param photo
	 */
	public Register(long id, String name, String lastname, String organization, String area, String email,
			String password, String platform, String caller, MultipartFile photo) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.organization = organization;
		this.area = area;
		this.email = email;
		this.password = password;
		super.setPlatform(platform);
		super.setCaller(caller);
		this.photo = photo;
	}
	
	@Override
	public String toString() {
		return "Register [id=" + id + ", " + (name != null ? "name=" + name + ", " : "")
				+ (lastname != null ? "lastname=" + lastname + ", " : "")
				+ (organization != null ? "organization=" + organization + ", " : "")
				+ (area != null ? "area=" + area + ", " : "") + (email != null ? "email=" + email + ", " : "")
				+ (password != null ? "password=" + password : "") 
				+ ", platform=" + super.getPlatform() 
				+ ", caller=" + super.getCaller() 
				+ "]";
	}	

}
