package com.koatchy.configGenerator.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author alfredo.barrios
 *
 */
@Component
@Scope(value="prototype")
public class SetNewPasswordRequest extends GeneralRequest  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("code")
	String code;

	@JsonProperty("newpassword")
	String newPassword;

	@JsonProperty("confirmpassword")
	String confirmPassword;
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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
	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	@Override
	public String toString() {
		return "SetNewPassword [code=" + code + ", newPassword=" + newPassword + ", confirmPassword=" + confirmPassword 
				+ "Platform: " + super.getPlatform() + ", Caller: " + super.getCaller() + "]";

	}

}
