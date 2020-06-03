/**
 * 
 */
package com.koatchy.configGenerator.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.koatchy.configGenerator.model.GeneralResponse;

/**
 * @author alfredo.barrios
 *
 */
public class ApiController implements ServiceController {

	@Override
	public void validateAuthorization(String authentication) throws Exception  {
		if(!authentication.equals("wDo3rXrE/")) 
			throw new Exception("No está autorizado a usar este servicio");
	}
	
	@Override
	@ExceptionHandler
	public GeneralResponse handlerException(Exception e) {
		System.out.println("handlerException: " + e.getMessage());
		return new GeneralResponse(-200, e.getMessage());
	}

}
