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
public class GetInitialDataRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("app")
	String App;
	@JsonProperty("dateTime")
	String DateTime;
	@JsonProperty("region")
	String Region;
	@JsonProperty("version")
	String Version;
	
	public GetInitialDataRequest() {}
	
	public GetInitialDataRequest(String app, String datetime, String region, String version) {
		this.App = app;
		this.DateTime = datetime;
		this.Region = region;
		this.Version = version;
	}

	@Override
	public String toString() {
		return "GetInitialDataRequest [App=" + App + ", DateTime=" + DateTime + ", Region=" + Region + ", Version=" + Version + "]";
	}

	public String getApp() {
		return App;
	}
	public void setApp(String app) {
		App = app;
	}
	public String getDateTime() {
		return DateTime;
	}
	public void setDateTime(String dateTime) {
		DateTime = dateTime;
	}
	public String getRegion() {
		return Region;
	}
	public void setRegion(String region) {
		Region = region;
	}
	public String getVersion() {
		return Version;
	}
	public void setVersion(String version) {
		Version = version;
	}
	
}
