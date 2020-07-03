package com.koatchy.configGenerator.model;

import java.io.Serializable;

public class TokenResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1L;

	private String name;
	private String lastname;
	private String organizationName;
	private String areaname;
	private String superuser;
	
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
	 * @return the organizationName
	 */
	public String getOrganizationName() {
		return organizationName;
	}

	/**
	 * @param organizationName the organizationName to set
	 */
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	/**
	 * @return the areaname
	 */
	public String getAreaname() {
		return areaname;
	}

	/**
	 * @param areaname the areaname to set
	 */
	public void setAreaname(String areaname) {
		this.areaname = areaname;
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

	/*
	 * 
	 */
	public TokenResponse() {}
	
	/**
	 * @param name
	 * @param lastname
	 * @param companyName
	 * @param areaname
	 * @param superuser
	 */
	public TokenResponse(String name, String lastname, String organizationName, String areaname, String superuser) {
		this.name = name;
		this.lastname = lastname;
		this.organizationName = organizationName;
		this.areaname = areaname;
		this.superuser = superuser;
	}
	
	@Override
	public String toString() {
		return "TokenResponse [" + (name != null ? "name=" + name + ", " : "")
				+ (lastname != null ? "lastname=" + lastname + ", " : "")
				+ (organizationName != null ? "organizationName=" + organizationName + ", " : "")
				+ (areaname != null ? "areaname=" + areaname + ", " : "")
				+ (superuser != null ? "superuser=" + superuser : "") + "]";
	}	
	
}
