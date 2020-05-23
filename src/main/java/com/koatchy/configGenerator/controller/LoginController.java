package com.koatchy.configGenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.koatchy.configGenerator.model.GeneralResponse;
import com.koatchy.configGenerator.model.KeyValue;
import com.koatchy.configGenerator.model.Login;
import com.koatchy.configGenerator.service.SecurityService;

@RequestMapping("/security")
@RestController
public class LoginController implements ServiceController {

	@Autowired
	SecurityService securitySrv;

	
	@RequestMapping(path = "login", method = RequestMethod.POST, produces = "application/JSON")
	public GeneralResponse login(@RequestHeader("authentication") String authentication, @RequestBody final Login param) throws Exception {
		validateAuthorization(authentication);
		GeneralResponse response = new GeneralResponse();
		response.setCode(200);
		response.setMessage("OK");
		response.setData(new KeyValue("token", securitySrv.validateCredentials(param)));		
		return response;
	}
	
	@Override
	public void validateAuthorization(String authentication) throws Exception  {
		if(!authentication.equals("wDo3rXrE/")) 
			throw new Exception("No está autorizado a usar este servicio");
	}
	
	@Override
	@ExceptionHandler
	public GeneralResponse handlerException(Exception e) {
		System.out.println("handlerException: " + e.toString());
		return new GeneralResponse(-200, "Error: " + e.toString());
	}
	
}
