package com.koatchy.configGenerator.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.koatchy.configGenerator.model.GeneralResponse;

public interface IServiceController {

	void setPlatform(String platform);

	void setCaller(String caller); 	
	
	void setApiName(String apiName);

	void logging(String successError, String errorMsg);

	void validateAuthorization(String authentication) throws Exception;
	
	@ExceptionHandler
	GeneralResponse handlerException(Exception e);
}
