/**
 * 
 */
package com.koatchy.configGenerator.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.koatchy.configGenerator.model.GeneralResponse;
import com.koatchy.configGenerator.model.VerifyCode;
import com.koatchy.configGenerator.service.SecurityService;

/**
 * @author alfredo.barrios
 *
 */
@RequestMapping("/security")
@RestController
public class CodeSetPassword extends ApiController {
	
	@Autowired
	SecurityService serviceSrv;
	
	@RequestMapping(path = "VerifyChangePasswordCode", method = RequestMethod.POST, produces = "application/JSON")
	public GeneralResponse VerifyChangePasswordCode(HttpServletRequest request, @RequestHeader("authentication") String authentication, @RequestBody final VerifyCode code) throws Exception {
	    /* The lines, below, get the origin of the called */
		//String origin = URI.create(request.getRequestURL().toString()).getHost();
	    //System.out.println(" Origin:" + origin);
	    validateAuthorization(authentication);
		GeneralResponse response = new GeneralResponse();
		response.setCode(200);
		response.setMessage("OK");
		response.setData(serviceSrv.VerifyChangePasswordCode(code));
		return response;
	}

}
