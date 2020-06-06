/**
 * 
 */
package com.koatchy.configGenerator.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author alfredo.barrios
 *
 */
@Entity
@Table(name="ctOrganizations")
public class Organization implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Organization() {}
	
	@Id
	@Column(name="idorganization")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="iconurl")
	private String iconurl;
	
	@Column(name="badgeurl")
	private String badgeurl;
	
	@Column(name="iduseroncharge")
	private String iduseroncharge;
	
	@Column(name="created_datetime")
	private String createdDatetime;
	
	@Column(name="created_platform")
	private String createdPlatform;
	
	@Column(name="updated_datetime")
	private String updated_datetime;
	
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
	 * @return the iconurl
	 */
	public String getIconurl() {
		return iconurl;
	}

	/**
	 * @param iconurl the iconurl to set
	 */
	public void setIconurl(String iconurl) {
		this.iconurl = iconurl;
	}

	/**
	 * @return the badgeurl
	 */
	public String getBadgeurl() {
		return badgeurl;
	}

	/**
	 * @param badgeurl the badgeurl to set
	 */
	public void setBadgeurl(String badgeurl) {
		this.badgeurl = badgeurl;
	}

	/**
	 * @return the iduseroncharge
	 */
	public String getIduseroncharge() {
		return iduseroncharge;
	}

	/**
	 * @param iduseroncharge the iduseroncharge to set
	 */
	public void setIduseroncharge(String iduseroncharge) {
		this.iduseroncharge = iduseroncharge;
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
	 * @return the updated_datetime
	 */
	public String getUpdated_datetime() {
		return updated_datetime;
	}

	/**
	 * @param updated_datetime the updated_datetime to set
	 */
	public void setUpdated_datetime(String updated_datetime) {
		this.updated_datetime = updated_datetime;
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
	 * @param name
	 * @param iconurl
	 * @param badgeurl
	 * @param iduseroncharge
	 * @param createdDatetime
	 * @param createdPlatform
	 * @param updated_datetime
	 * @param updatedPlatform
	 */
	public Organization(long id, String name, String iconurl, String badgeurl, String iduseroncharge,
			String createdDatetime, String createdPlatform, String updated_datetime, String updatedPlatform) {
		this.id = id;
		this.name = name;
		this.iconurl = iconurl;
		this.badgeurl = badgeurl;
		this.iduseroncharge = iduseroncharge;
		this.createdDatetime = createdDatetime;
		this.createdPlatform = createdPlatform;
		this.updated_datetime = updated_datetime;
		this.updatedPlatform = updatedPlatform;
	}

	@Override
	public String toString() {
		return "Organization [id=" + id + ", name=" + name + ", iconurl=" + iconurl + ", badgeurl=" + badgeurl
				+ ", iduseroncharge=" + iduseroncharge + ", createdDatetime=" + createdDatetime + ", createdPlatform="
				+ createdPlatform + ", updated_datetime=" + updated_datetime + ", updatedPlatform=" + updatedPlatform
				+ "]";
	}
	
}
