package com.koatchy.configGenerator.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class GeneralResponse {
	Integer Code = 0;
	String Message = "";
	Object Response = "";
	public Integer getCode() {
		return Code;
	}
	public void setCode(Integer code) {
		Code = code;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public Object getResponse() {
		return Response;
	}
	public void setResponse(Object response) {
		Response = response;
	}
	public GeneralResponse() {}
	public GeneralResponse(Integer code, String message) {
		this.Code = code;
		this.Message = message;
	}
	public GeneralResponse(Integer code, String message, Object response) {
		this.Code = code;
		this.Message = message;
		this.Response = response;
	}
}
