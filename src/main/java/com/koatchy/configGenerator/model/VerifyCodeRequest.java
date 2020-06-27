/**
 * 
 */
package com.koatchy.configGenerator.model;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author alfredo.barrios
 *
 */
@Component
@Scope(value="prototype")
public class VerifyCodeRequest extends GeneralRequest implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("code")
	private String code;

	public VerifyCodeRequest(String code) {
		super();
		this.code = code;
	}

	public VerifyCodeRequest() {
	}

	
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
