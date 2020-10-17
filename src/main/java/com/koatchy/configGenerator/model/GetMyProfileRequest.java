package com.koatchy.configGenerator.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author alfredo.barrios
 *
 */
@Component
@Scope(value="prototype")
public class GetMyProfileRequest extends GeneralRequest {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;

	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	public GetMyProfileRequest() {}

	/**
	 * @param id
	 */
	public GetMyProfileRequest(Long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "RegisterRequest [" + (id != null ? "id=" + id + ", " : "")  + "]";
	}
	
}
