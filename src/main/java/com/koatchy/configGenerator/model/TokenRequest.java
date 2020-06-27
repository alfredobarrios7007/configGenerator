/**
 * 
 */
package com.koatchy.configGenerator.model;

import java.io.Serializable;

/**
 * @author alfredo.barrios
 *
 */
public class TokenRequest extends GeneralRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String token;

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @param token
	 */
	public TokenRequest(String token) {
		this.token = token;
	}

	/**
	 * 
	 */
	public TokenRequest() {
	}

	@Override
	public String toString() {
		return "TokenRequest [" + (token != null ? "token=" + token : "") + "]";
	}
	

}
