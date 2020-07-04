package com.koatchy.configGenerator.model;

import java.io.Serializable;

public class Project  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1L;

	private Long id;
	private String name;
	private String description;
	private String urlIcon;
	private String urlBadge;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the urlIcon
	 */
	public String getUrlIcon() {
		return urlIcon;
	}
	/**
	 * @param urlIcon the urlIcon to set
	 */
	public void setUrlIcon(String urlIcon) {
		this.urlIcon = urlIcon;
	}
	/**
	 * @return the urlBadge
	 */
	public String getUrlBadge() {
		return urlBadge;
	}
	/**
	 * @param urlBadge the urlBadge to set
	 */
	public void setUrlBadge(String urlBadge) {
		this.urlBadge = urlBadge;
	}
	
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param urlIcon
	 * @param urlBadge
	 */
	public Project(Long id, String name, String description, String urlIcon, String urlBadge) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.urlIcon = urlIcon;
		this.urlBadge = urlBadge;
	}

	@Override
	public String toString() {
		return "Project [" + (id != null ? "id=" + id + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (description != null ? "description=" + description + ", " : "")
				+ (urlIcon != null ? "urlIcon=" + urlIcon + ", " : "")
				+ (urlBadge != null ? "urlBadge=" + urlBadge : "") + "]";
	}
	
}
