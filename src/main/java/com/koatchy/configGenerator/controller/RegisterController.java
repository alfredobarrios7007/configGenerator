package com.koatchy.configGenerator.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.koatchy.configGenerator.model.GeneralResponse;
import com.koatchy.configGenerator.model.KeyValue;
import com.koatchy.configGenerator.model.Login;
import com.koatchy.configGenerator.service.SecurityService;

/**
 * @author alfredo.barrios
 *
 */
@RequestMapping("/security")
@RestController
public class RegisterController extends ApiController {

	@Autowired
	SecurityService securitySrv;
	
	@RequestMapping(path = "register", method = RequestMethod.POST, produces = "application/JSON")
	public GeneralResponse register(HttpServletRequest request, @RequestHeader("authentication") String authentication, @RequestBody final Login param) throws Exception {
	    /* The lines, below, get the origin of the called */
		//String origin = URI.create(request.getRequestURL().toString()).getHost();
	    //System.out.println(" Origin:" + origin);
	    validateAuthorization(authentication);
		GeneralResponse response = new GeneralResponse();
		response.setCode(200);
		response.setMessage("OK");
		response.setData(new KeyValue("token", securitySrv.validateCredentials(param)));		
		return response;
	}

	
}
