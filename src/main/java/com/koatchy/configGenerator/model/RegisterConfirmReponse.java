/**
 * 
 */
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
public class RegisterConfirmReponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RegisterConfirmReponse(){}
	
	private String Username;
	private String WelcomeMessage;

	/**
	 * @param username
	 * @param welcomeMessage
	 */
	public RegisterConfirmReponse(String username, String welcomeMessage) {
		Username = username;
		WelcomeMessage = welcomeMessage;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return Username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		Username = username;
	}

	/**
	 * @return the welcomeMessage
	 */
	public String getWelcomeMessage() {
		return WelcomeMessage;
	}

	/**
	 * @param welcomeMessage the welcomeMessage to set
	 */
	public void setWelcomeMessage(String welcomeMessage) {
		WelcomeMessage = welcomeMessage;
	}

	@Override
	public String toString() {
		return "RegisterConfirmReponse [" + (Username != null ? "Username=" + Username + ", " : "")
				+ (WelcomeMessage != null ? "WelcomeMessage=" + WelcomeMessage : "") + "]";
	}

}
