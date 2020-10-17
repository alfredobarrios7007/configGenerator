package com.koatchy.configGenerator.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.io.Serializable;

/**
 * @author alfredo.barrios
 *
 */
@Component
@Scope(value="prototype")
public class RegisterConfirmRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;

	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the id to set
	 */
	public void setCode(String code) {
		this.code = code;
	}


	public RegisterConfirmRequest() {}

	/**
	 * @param code
	 */
	public RegisterConfirmRequest(String code) {
		this.code = code;
	}


	@Override
	public String toString() {
		return "RegisterConfirmRequest [" + (code != null ? "code=" + code + ", " : "")  + "]";
	}
	
}
