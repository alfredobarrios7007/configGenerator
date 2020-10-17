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
public class RegisterRequest extends GeneralRequest {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String lastname;
	private String email;
	private String organization;
	private String organizationrole;
	private String area;
	private String password;
	private String photoPath;
	private String confirmed;
	private String superuser;
	private String enabled;
	private String created_date;
	private String created_user;
	private String updated_date;
	private String updated_user;
	private MultipartFile photo;

	
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
	 * @return the organizationrole
	 */
	public String getOrganizationrole() {
		return organizationrole;
	}

	/**
	 * @param organizationrole the organizationrol to set
	 */
	public void setOrganizationrole(String organizationrole) {
		this.organizationrole = organizationrole;
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
	 * @return the photoPath
	 */
	public String getPhotoPath() {
		return photoPath;
	}

	/**
	 * @param photoPath the photoPath to set
	 */
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
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
	 * @return the enabled
	 */
	public String getEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the created_date
	 */
	public String getCreated_date() {
		return created_date;
	}

	/**
	 * @param created_date the created_date to set
	 */
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	/**
	 * @return the created_user
	 */
	public String getCreated_user() {
		return created_user;
	}

	/**
	 * @param created_user the created_user to set
	 */
	public void setCreated_user(String created_user) {
		this.created_user = created_user;
	}

	/**
	 * @return the updated_date
	 */
	public String getUpdated_date() {
		return updated_date;
	}

	/**
	 * @param updated_date the updated_date to set
	 */
	public void setUpdated_date(String updated_date) {
		this.updated_date = updated_date;
	}

	/**
	 * @return the updated_user
	 */
	public String getUpdated_user() {
		return updated_user;
	}

	/**
	 * @param updated_user the updated_user to set
	 */
	public void setUpdated_user(String updated_user) {
		this.updated_user = updated_user;
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

	public RegisterRequest() {}

	/**
	 * @param id
	 * @param name
	 * @param lastname
	 * @param email
	 * @param organization
	 * @param organizationrole
	 * @param area
	 * @param password
	 * @param photoPath
	 * @param confirmed
	 * @param superuser
	 * @param enabled
	 * @param created_date
	 * @param created_user
	 * @param updated_date
	 * @param updated_user
	 * @param photo
	 */
	public RegisterRequest(Long id, String name, String lastname, String email, String organization,
			String organizationrole, String area, String password, String photoPath, String confirmed, String superuser,
			String enabled, String created_date, String created_user, String updated_date, String updated_user, String platform, String caller) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.organization = organization;
		this.organizationrole = organizationrole;
		this.area = area;
		this.password = password;
		this.photoPath = photoPath;
		this.confirmed = confirmed;
		this.superuser = superuser;
		this.enabled = enabled;
		this.created_date = created_date;
		this.created_user = created_user;
		this.updated_date = updated_date;
		this.updated_user = updated_user;
		super.setPlatform(platform);
		super.setCaller(caller);
	}

	/**
	 * @param id
	 * @param name
	 * @param lastname
	 * @param email
	 * @param organization
	 * @param organizationrole
	 * @param area
	 * @param photoPath
	 * @param confirmed
	 * @param superuser
	 * @param enabled
	 */
	public RegisterRequest(Long id, String name, String lastname, String email, String organization, String organizationrole, 
			String area, String confirmed, String superuser, String platform, String caller) {
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.organization = organization;
		this.organizationrole = organizationrole;
		this.area = area;
		this.confirmed = confirmed;
		this.superuser = superuser;
		super.setPlatform(platform);
		super.setCaller(caller);
	}


	/**
	 * @param id
	 * @param photo
	 */
	public RegisterRequest(Long id, String platform, String caller, MultipartFile photo) {
		this.id = id;
		super.setPlatform(platform);
		super.setCaller(caller);
		this.photo = photo;
	}
	
	
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
	public RegisterRequest(Long id, String name, String lastname, String organization, String area, String email,
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
		return "RegisterRequest [" + (id != null ? "id=" + id + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (lastname != null ? "lastname=" + lastname + ", " : "")
				+ (email != null ? "email=" + email + ", " : "")
				+ (organization != null ? "organization=" + organization + ", " : "")
				+ (organizationrole != null ? "organizationrole=" + organizationrole + ", " : "")
				+ (area != null ? "area=" + area + ", " : "") + (password != null ? "password=" + password + ", " : "")
				+ (photoPath != null ? "photoPath=" + photoPath + ", " : "")
				+ (confirmed != null ? "confirmed=" + confirmed + ", " : "")
				+ (superuser != null ? "superuser=" + superuser + ", " : "")
				+ (enabled != null ? "enabled=" + enabled + ", " : "")
				+ (created_date != null ? "created_date=" + created_date + ", " : "")
				+ (created_user != null ? "created_user=" + created_user + ", " : "")
				+ (updated_date != null ? "updated_date=" + updated_date + ", " : "")
				+ (updated_user != null ? "updated_user=" + updated_user + ", " : "")
				+ (photo != null ? "photo=" + photo : "") + "]";
	}
	
}
