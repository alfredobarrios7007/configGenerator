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
@Table(name="ctorganizationroles")
public class OrganizationRol implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idorganizationrol")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="namees")
	private String namees;

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
	 * @return the namees
	 */
	public String getNamees() {
		return namees;
	}

	/**
	 * @param namees the namees to set
	 */
	public void setNamees(String namees) {
		this.namees = namees;
	}

	public OrganizationRol() {
		
	}	
	
	/**
	 * @param id
	 * @param namees
	 */
	public OrganizationRol(Long id, String namees) {
		this.id = id;
		this.namees = namees;
	}

	@Override
	public String toString() {
		return "OrganizationRol [" + (id != null ? "id=" + id + ", " : "") + (namees != null ? "namees=" + namees : "")
				+ "]";
	}
	
}
