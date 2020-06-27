package com.koatchy.configGenerator.model;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author alfredo.barrios
 *
 */
@Component
@Scope(value="prototype")
public class SetNewPassword implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String email;
	String newPassword;
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}
	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	@Override
	public String toString() {
		return "SetNewPassword [email=" + email + ", newPassword=" + newPassword + ", getEmail()=" + getEmail()
				+ ", getNewPassword()=" + getNewPassword() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	/**
	 * @param email
	 * @param newPassword
	 */
	public SetNewPassword(String email, String newPassword) {
		this.email = email;
		this.newPassword = newPassword;
	}
	/**
	 * 
	 */
	public SetNewPassword() {
	}

}