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
@Table(name="cfaddreesses")
public class Address implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Address() {}
	
	@Id
	@Column(name="idaddress")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="idcompany")
	private long idcompany;
	
	@Column(name="phonenum1")
	private String phonenum1;
	
	@Column(name="phonenum2")
	private String phonenum2;
	
	@Column(name="faxnum")
	private String faxnum;
	
	@Column(name="street")
	private String street;
	
	@Column(name="interiornum")
	private String interiornum;
	
	@Column(name="exteriornum")
	private String exteriornum;
	
	@Column(name="neighborhood")
	private String neighborhood;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@Column(name="zipcode")
	private String zipcode;
	
	@Column(name="idcountry")
	private String idcountry;
	
	@Column(name="created_datetime")
	private String createdDatetime;
	
	@Column(name="created_platform")
	private String createdPlatform;
	
	@Column(name="updated_datetime")
	private String updatedDatetime;
	
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
	 * @return the idcompany
	 */
	public long getIdcompany() {
		return idcompany;
	}

	/**
	 * @param idcompany the idcompany to set
	 */
	public void setIdcompany(long idcompany) {
		this.idcompany = idcompany;
	}

	/**
	 * @return the phonenum1
	 */
	public String getPhonenum1() {
		return phonenum1;
	}

	/**
	 * @param phonenum1 the phonenum1 to set
	 */
	public void setPhonenum1(String phonenum1) {
		this.phonenum1 = phonenum1;
	}

	/**
	 * @return the phonenum2
	 */
	public String getPhonenum2() {
		return phonenum2;
	}

	/**
	 * @param phonenum2 the phonenum2 to set
	 */
	public void setPhonenum2(String phonenum2) {
		this.phonenum2 = phonenum2;
	}

	/**
	 * @return the faxnum
	 */
	public String getFaxnum() {
		return faxnum;
	}

	/**
	 * @param faxnum the faxnum to set
	 */
	public void setFaxnum(String faxnum) {
		this.faxnum = faxnum;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the interiornum
	 */
	public String getInteriornum() {
		return interiornum;
	}

	/**
	 * @param interiornum the interiornum to set
	 */
	public void setInteriornum(String interiornum) {
		this.interiornum = interiornum;
	}

	/**
	 * @return the exteriornum
	 */
	public String getExteriornum() {
		return exteriornum;
	}

	/**
	 * @param exteriornum the exteriornum to set
	 */
	public void setExteriornum(String exteriornum) {
		this.exteriornum = exteriornum;
	}

	/**
	 * @return the neighborhood
	 */
	public String getNeighborhood() {
		return neighborhood;
	}

	/**
	 * @param neighborhood the neighborhood to set
	 */
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zip
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * @param zip the zip to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 * @return the idcountry
	 */
	public String getIdcountry() {
		return idcountry;
	}

	/**
	 * @param idcountry the idcountry to set
	 */
	public void setIdcountry(String idcountry) {
		this.idcountry = idcountry;
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
	 * @param idcompany
	 * @param phonenum1
	 * @param phonenum2
	 * @param faxnum
	 * @param street
	 * @param interiornum
	 * @param exteriornum
	 * @param neighborhood
	 * @param city
	 * @param state
	 * @param zipcode
	 * @param idcountry
	 * @param createdDatetime
	 * @param createdPlatform
	 * @param updatedDatetime
	 * @param updatedPlatform
	 */
	public Address(Long id, long idcompany, String phonenum1, String phonenum2, String faxnum, String street,
			String interiornum, String exteriornum, String neighborhood, String city, String state, String zipcode,
			String idcountry, String createdDatetime, String createdPlatform, String updatedDatetime,
			String updatedPlatform) {
		this.id = id;
		this.idcompany = idcompany;
		this.phonenum1 = phonenum1;
		this.phonenum2 = phonenum2;
		this.faxnum = faxnum;
		this.street = street;
		this.interiornum = interiornum;
		this.exteriornum = exteriornum;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.idcountry = idcountry;
		this.createdDatetime = createdDatetime;
		this.createdPlatform = createdPlatform;
		this.updatedDatetime = updatedDatetime;
		this.updatedPlatform = updatedPlatform;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", idcompany=" + idcompany + ", phonenum1=" + phonenum1 + ", phonenum2="
				+ phonenum2 + ", faxnum=" + faxnum + ", street=" + street + ", interiornum=" + interiornum
				+ ", exteriornum=" + exteriornum + ", neighborhood=" + neighborhood + ", city=" + city + ", state="
				+ state + ", zipcode=" + zipcode + ", idcountry=" + idcountry + ", createdDatetime=" + createdDatetime
				+ ", createdPlatform=" + createdPlatform + ", updatedDatetime=" + updatedDatetime + ", updatedPlatform="
				+ updatedPlatform + "]";
	}

}
