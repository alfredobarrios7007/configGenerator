/**
 * 
 */
package com.koatchy.configGenerator.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author alfredo.barrios
 *
 */
@Component
@Scope(value="prototype")
public class VerifyCode {

	private String code;

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

	@Override
	public String toString() {
		return "VerifyCode [code=" + code + "]";
	}
	
	
}
