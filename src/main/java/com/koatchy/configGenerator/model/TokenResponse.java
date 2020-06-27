package com.koatchy.configGenerator.model;

import java.io.Serializable;

public class TokenResponse extends GeneralResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1L;

	private String name;
	private String lastname;
	private String companyName;
	private String areaname;
	private Boolean superuser;
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
	public Boolean getSuperuser() {
		return superuser;
	}
	/**
	 * @param superuser the superuser to set
	 */
	public void setSuperuser(Boolean superuser) {
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
	public TokenResponse(String name, String lastname, String companyName, String areaname, Boolean superuser) {
		this.name = name;
		this.lastname = lastname;
		this.companyName = companyName;
		this.areaname = areaname;
		this.superuser = superuser;
	}
	
	@Override
	public String toString() {
		return "TokenResponse [" + (name != null ? "name=" + name + ", " : "")
				+ (lastname != null ? "lastname=" + lastname + ", " : "")
				+ (companyName != null ? "companyName=" + companyName + ", " : "")
				+ (areaname != null ? "areaname=" + areaname + ", " : "")
				+ (superuser != null ? "superuser=" + superuser : "") + "]";
	}	
	
}
