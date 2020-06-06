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
public class Country implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public Country() {}
	
	@Id
	@Column(name="idcountry")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="shortname")
	private String shortname;
	
	@Column(name="capital")
	private String capital;
	
	@Column(name="currency")
	private String currency;


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
	 * @return the shortname
	 */
	public String getShortname() {
		return shortname;
	}

	/**
	 * @param shortname the shortname to set
	 */
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	/**
	 * @return the capital
	 */
	public String getCapital() {
		return capital;
	}

	/**
	 * @param capital the capital to set
	 */
	public void setCapital(String capital) {
		this.capital = capital;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @param id
	 * @param name
	 * @param shortname
	 * @param capital
	 * @param currency
	 */
	public Country(long id, String name, String shortname, String capital, String currency) {
		this.id = id;
		this.name = name;
		this.shortname = shortname;
		this.capital = capital;
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", shortname=" + shortname + ", capital=" + capital
				+ ", currency=" + currency + "]";
	}
	
	

}
