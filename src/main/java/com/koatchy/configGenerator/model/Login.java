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
public class Login {

	private String Username;
	private String Password;
	
	public Login() {}
	public Login(String username, String password) {
		this.Username = username;
		this.Password = password;
	}
	@Override
	public String toString() {
		return "Login [Username=" + Username + ", Password=" + Password + "]";
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
	
	
	
}
