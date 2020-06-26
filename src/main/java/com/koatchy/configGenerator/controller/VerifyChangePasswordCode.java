/**
 * 
 */
package com.koatchy.configGenerator.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
public class VerifyChangePasswordCode extends ServiceControllerImpl implements IServiceController {
	
	@Autowired
	SecurityService objectSrv;
	
	@RequestMapping(path = "VerifyChangePasswordCode", method = RequestMethod.POST, produces = "application/JSON")
	public GeneralResponse verifyChangePasswordCode(HttpServletRequest request, @RequestHeader("authentication") String authentication, @RequestBody final VerifyCode param) throws Exception {
		System.out.print("VerifyChangePasswordCode " + param.toString() + "\n");
	    /* The lines, below, get the origin of the called */
		//String origin = URI.create(request.getRequestURL().toString()).getHost();
		setApiName("catlogs-getAllAreas");
		setPlatform(param.getPlatform());
		setCaller(param.getCaller());
	    validateAuthorization(authentication);
		GeneralResponse response = new GeneralResponse();
		response.setCode(200);
		response.setMessage("OK");
		response.setData(objectSrv.verifyChangePasswordCode(param));
		return response;
	}
	
	@Override
	@ExceptionHandler
	public GeneralResponse handlerException(Exception e) {
		System.out.println("handlerException: " + e.getMessage() + "\n");
		setApiName("catlogs-getAllAreas");
		logging("error", e.getMessage());
		return new GeneralResponse(-200, e.getMessage());
	}

}
