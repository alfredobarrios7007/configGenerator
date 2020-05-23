package com.koatchy.configGenerator.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.koatchy.configGenerator.model.GeneralResponse;

public interface ServiceController {

	void validateAuthorization(String authentication) throws Exception;
	
	@ExceptionHandler
	GeneralResponse handlerException(Exception e);
}
