package com.koatchy.configGenerator.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ctuserareas")
public class UserArea implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserArea() {}

	/**
	 * @param id
	 * @param name
	 * @param notify
	 */
	public UserArea(long id, String name, String notify) {
		this.id = id;
		this.name = name;
		this.notify = notify;
	}

	@Id
	@Column(name="iduserarea")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="name")
	private String name;

	@Column(name="notify")
	private String notify;

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
	 * @return the notify
	 */
	public String getNotify() {
		return notify;
	}

	/**
	 * @param notify the notify to set
	 */
	public void setNotify(String notify) {
		this.notify = notify;
	}

	@Override
	public String toString() {
		return "UserArea [id=" + id + ", name=" + name + ", notify=" + notify + "]";
	}
	
}
