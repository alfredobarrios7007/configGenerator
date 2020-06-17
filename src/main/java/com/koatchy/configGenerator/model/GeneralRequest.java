/**
 * 
 */
package com.koatchy.configGenerator.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author alfredo.barrios
 *
 */
public class GeneralRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("platform")
	private String platform;
	
	@JsonProperty("caller")
	private String caller;
	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}
	/**
	 * @param platform the platform to set
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	/**
	 * @return the caller
	 */
	public String getCaller() {
		return caller;
	}
	/**
	 * @param caller the caller to set
	 */
	public void setCaller(String caller) {
		this.caller = caller;
	}
	
	@Override
	public String toString() {
		return "GeneralRequest [" + (platform != null ? "platform=" + platform + ", " : "")
				+ (caller != null ? "caller=" + caller : "") + "]";
	}	
	
	
}
