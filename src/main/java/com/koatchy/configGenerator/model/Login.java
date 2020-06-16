/**
 * 
 */
package com.koatchy.configGenerator.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author alfredo.barrios
 * @date April 16, 2016
 */
@Component
@Scope(value="prototype")
public class Login extends GeneralRequest {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String Username;
	private String Password;
	
	public Login() {}
	
	public Login(String platform, String caller, String username, String password) {
		this.Username = username;
		this.Password = password;
		super.setCaller(caller);
		super.setPlatform(platform);
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "Login [" + (Username != null ? "Username=" + Username + ", " : "")
				+ (Password != null ? "Password=" + Password + ", " : "") 
				+ "Platform: " + super.getPlatform() + ", Caller: " + super.getCaller() + "]";
	}	
	
}
