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
@Table(name="subscritionsOffers")
public class Offer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public Offer() {}

	@Id
	@Column(name="idoffer")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="idproject",nullable = false)
	private Long idproject;
	
	@Column(name="description",nullable = false)
	private String description;

	@Column(name="maximumdownloads",nullable = false)
	private Integer maximumdownloads;

	@Column(name="maximumusers",nullable = false)
	private Integer maximumusers;

	@Column(name="maximumapplications",nullable = false)
	private Integer maximumapplications;

	@Column(name="maximumprofiles",nullable = false)
	private Integer maximumprofiles;

	@Column(name="maximumversionbyapp",nullable = false)
	private Integer maximumversionbyapp;

	@Column(name="enabled",nullable = false)
	private String enabled;

	@Column(name="show",nullable = false)
	private String show;

	@Column(name="datestart",nullable = true)
	private String datestart;

	@Column(name="datefinish",nullable = true)
	private String datefinish;
	
	@Column(name="created_datetime",nullable = false)
	private String createdDatetime;
	
	@Column(name="created_platform",nullable = false)
	private String createdPlatform;
	
	@Column(name="updated_datetime",nullable = true)
	private String updatedDatetime;
	
	@Column(name="updated_platform",nullable = true)
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
	 * @return the idproject
	 */
	public Long getIdproject() {
		return idproject;
	}

	/**
	 * @param idproject the idproject to set
	 */
	public void setIdproject(Long idproject) {
		this.idproject = idproject;
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
	 * @return the maximumdownloads
	 */
	public Integer getMaximumdownloads() {
		return maximumdownloads;
	}

	/**
	 * @param maximumdownloads the maximumdownloads to set
	 */
	public void setMaximumdownloads(Integer maximumdownloads) {
		this.maximumdownloads = maximumdownloads;
	}

	/**
	 * @return the maximumusers
	 */
	public Integer getMaximumusers() {
		return maximumusers;
	}

	/**
	 * @param maximumusers the maximumusers to set
	 */
	public void setMaximumusers(Integer maximumusers) {
		this.maximumusers = maximumusers;
	}

	/**
	 * @return the maximumapplications
	 */
	public Integer getMaximumapplications() {
		return maximumapplications;
	}

	/**
	 * @param maximumapplications the maximumapplications to set
	 */
	public void setMaximumapplications(Integer maximumapplications) {
		this.maximumapplications = maximumapplications;
	}

	/**
	 * @return the maximumprofiles
	 */
	public Integer getMaximumprofiles() {
		return maximumprofiles;
	}

	/**
	 * @param maximumprofiles the maximumprofiles to set
	 */
	public void setMaximumprofiles(Integer maximumprofiles) {
		this.maximumprofiles = maximumprofiles;
	}

	/**
	 * @return the maximumversionbyapp
	 */
	public Integer getMaximumversionbyapp() {
		return maximumversionbyapp;
	}

	/**
	 * @param maximumversionbyapp the maximumversionbyapp to set
	 */
	public void setMaximumversionbyapp(Integer maximumversionbyapp) {
		this.maximumversionbyapp = maximumversionbyapp;
	}

	/**
	 * @return the enabled
	 */
	public String getEnabled() {
		return enabled;
	}

	/**
	 * @param Enabled the Enabled to set
	 */
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the show
	 */
	public String getShow() {
		return show;
	}

	/**
	 * @param show the show to set
	 */
	public void setShow(String show) {
		this.show = show;
	}

	/**
	 * @return the datestart
	 */
	public String getDatestart() {
		return datestart;
	}

	/**
	 * @param datestart the datestart to set
	 */
	public void setDatestart(String datestart) {
		this.datestart = datestart;
	}

	/**
	 * @return the datefinish
	 */
	public String getDatefinish() {
		return datefinish;
	}

	/**
	 * @param datefinish the datefinish to set
	 */
	public void setDatefinish(String datefinish) {
		this.datefinish = datefinish;
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
	 * @param idproject
	 * @param description
	 * @param maximumdownloads
	 * @param maximumusers
	 * @param maximumapplications
	 * @param maximumprofiles
	 * @param maximumversionbyapp
	 * @param enabled
	 * @param show
	 * @param datestart
	 * @param datefinish
	 * @param createdDatetime
	 * @param createdPlatform
	 * @param updatedDatetime
	 * @param updatedPlatform
	 */
	public Offer(Long id, Long idproject, String description, Integer maximumdownloads, Integer maximumusers,
			Integer maximumapplications, Integer maximumprofiles, Integer maximumversionbyapp, String enabled,
			String show, String datestart, String datefinish, String createdDatetime, String createdPlatform,
			String updatedDatetime, String updatedPlatform) {
		this.id = id;
		this.idproject = idproject;
		this.description = description;
		this.maximumdownloads = maximumdownloads;
		this.maximumusers = maximumusers;
		this.maximumapplications = maximumapplications;
		this.maximumprofiles = maximumprofiles;
		this.maximumversionbyapp = maximumversionbyapp;
		this.enabled = enabled;
		this.show = show;
		this.datestart = datestart;
		this.datefinish = datefinish;
		this.createdDatetime = createdDatetime;
		this.createdPlatform = createdPlatform;
		this.updatedDatetime = updatedDatetime;
		this.updatedPlatform = updatedPlatform;
	}

	@Override
	public String toString() {
		return "Offer [" + (id != null ? "id=" + id + ", " : "")
				+ (idproject != null ? "idproject=" + idproject + ", " : "")
				+ (description != null ? "description=" + description + ", " : "")
				+ (maximumdownloads != null ? "maximumdownloads=" + maximumdownloads + ", " : "")
				+ (maximumusers != null ? "maximumusers=" + maximumusers + ", " : "")
				+ (maximumapplications != null ? "maximumapplications=" + maximumapplications + ", " : "")
				+ (maximumprofiles != null ? "maximumprofiles=" + maximumprofiles + ", " : "")
				+ (maximumversionbyapp != null ? "maximumversionbyapp=" + maximumversionbyapp + ", " : "")
				+ (enabled != null ? "enabled=" + enabled + ", " : "")
				+ (show != null ? "show=" + show + ", " : "")
				+ (datestart != null ? "datestart=" + datestart + ", " : "")
				+ (datefinish != null ? "datefinish=" + datefinish + ", " : "")
				+ (createdDatetime != null ? "createdDatetime=" + createdDatetime + ", " : "")
				+ (createdPlatform != null ? "createdPlatform=" + createdPlatform + ", " : "")
				+ (updatedDatetime != null ? "updatedDatetime=" + updatedDatetime + ", " : "")
				+ (updatedPlatform != null ? "updatedPlatform=" + updatedPlatform : "") + "]";
	}

	
}
