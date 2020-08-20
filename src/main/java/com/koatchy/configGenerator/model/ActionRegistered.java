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
public class ActionRegistered extends GeneralRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1L;

	private String logname;
	private String screen;
	private String action;
	private String profile;
	private String phonenumber;
	private String platform;
	/**
	 * @return the logname
	 */
	public String getLogname() {
		return logname;
	}
	/**
	 * @param logname the logname to set
	 */
	public void setLogname(String logname) {
		this.logname = logname;
	}
	/**
	 * @return the screen
	 */
	public String getScreen() {
		return screen;
	}
	/**
	 * @param screen the screen to set
	 */
	public void setScreen(String screen) {
		this.screen = screen;
	}
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * @return the profile
	 */
	public String getProfile() {
		return profile;
	}
	/**
	 * @param profile the profile to set
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}
	/**
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}
	/**
	 * @param phonenumber the phonenumber to set
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
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
	 * @param logname
	 * @param screen
	 * @param action
	 * @param profile
	 * @param phonenumber
	 * @param platform
	 */
	public ActionRegistered(String logname, String screen, String action, String profile, String phonenumber,
			String platform) {
		this.logname = logname;
		this.screen = screen;
		this.action = action;
		this.profile = profile;
		this.phonenumber = phonenumber;
		this.platform = platform;
	}

	@Override
	public String toString() {
		return "ActionRegistered [" + (logname != null ? "logname=" + logname + ", " : "")
				+ (screen != null ? "screen=" + screen + ", " : "") + (action != null ? "action=" + action + ", " : "")
				+ (profile != null ? "profile=" + profile + ", " : "")
				+ (phonenumber != null ? "phonenumber=" + phonenumber + ", " : "")
				+ (platform != null ? "platform=" + platform : "") + "]";
	}
		
}
