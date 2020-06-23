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
@Table(name="cfconfigurations")
public class Configuration  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public Configuration() {}
	
	public Configuration(Long id, String description, String valueOf) {
		this.id = id;
		this.description = description;
		this.valueOf = valueOf;
	}

	@Id
	@Column(name="idconfiguration")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="description",nullable = true)
	private String description;
	
	@Column(name="valueof",nullable = true)
	private String valueOf;


	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the value
	 */
	public String getValueOf() {
		return valueOf;
	}

	/**
	 * @param value the value to set
	 */
	public void setValueOf(String valueOf) {
		this.valueOf = valueOf;
	}

	@Override
	public String toString() {
		return "Configuration [id=" + id + ", description=" + description + ", valueOf=" + valueOf + "]";
	}

}
