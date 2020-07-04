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
@Table(name="ctprojects")
public class Project implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name="idproject")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="iconurl")
	private String iconUrl;
	
	@Column(name="badgeurl")
	private String badgeUrl;
	
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the iconUrl
	 */
	public String getIconUrl() {
		return iconUrl;
	}

	/**
	 * @param iconUrl the iconUrl to set
	 */
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	/**
	 * @return the badgeUrl
	 */
	public String getBadgeUrl() {
		return badgeUrl;
	}

	/**
	 * @param badgeUrl the badgeUrl to set
	 */
	public void setBadgeUrl(String badgeUrl) {
		this.badgeUrl = badgeUrl;
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
	 * 
	 */
	public Project() {}
	
	
	/**
	 * @param id
	 * @param name
	 * @param descripcion
	 * @param iconUrl
	 * @param badgeUrl
	 * @param createdDatetime
	 * @param createdPlatform
	 * @param updated_datetime
	 * @param updatedPlatform
	 */
	public Project(Long id, String name, String descripcion, String iconUrl, String badgeUrl, String createdDatetime,
			String createdPlatform, String updated_datetime, String updatedPlatform) {
		this.id = id;
		this.name = name;
		this.descripcion = descripcion;
		this.iconUrl = iconUrl;
		this.badgeUrl = badgeUrl;
		this.createdDatetime = createdDatetime;
		this.createdPlatform = createdPlatform;
		this.updated_datetime = updated_datetime;
		this.updatedPlatform = updatedPlatform;
	}

	@Override
	public String toString() {
		return "Project [" + (id != null ? "id=" + id + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (descripcion != null ? "descripcion=" + descripcion + ", " : "")
				+ (iconUrl != null ? "iconUrl=" + iconUrl + ", " : "")
				+ (badgeUrl != null ? "badgeUrl=" + badgeUrl + ", " : "")
				+ (createdDatetime != null ? "createdDatetime=" + createdDatetime + ", " : "")
				+ (createdPlatform != null ? "createdPlatform=" + createdPlatform + ", " : "")
				+ (updated_datetime != null ? "updated_datetime=" + updated_datetime + ", " : "")
				+ (updatedPlatform != null ? "updatedPlatform=" + updatedPlatform : "") + "]";
	}
		
}
