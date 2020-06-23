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
import com.koatchy.configGenerator.model.Login;
import com.koatchy.configGenerator.service.UserService;

/**
 * @author alfredo.barrios
 *
 */
@RequestMapping("/security")
@RestController
public class RecoveryPasswordController extends ServiceControllerImpl {
	
	@Autowired
	UserService objectSrv;
	
	@RequestMapping(path = "recoveryPassword", method = RequestMethod.POST, produces = "application/JSON")
	public GeneralResponse recoveryPassword(HttpServletRequest request, @RequestHeader("authentication") String authentication, @RequestBody final Login param) throws Exception {
		System.out.print("recoveryPassword " + param.toString() + "\n");
		setApiName("security-recoveryPassword");
		setPlatform(param.getPlatform());
		setCaller(param.getCaller());
	    /* The lines, below, get the origin of the called */
		//String origin = URI.create(request.getRequestURL().toString()).getHost();
	    //System.out.println(" Origin:" + origin);
	    validateAuthorization(authentication);
		GeneralResponse response = new GeneralResponse();
		response.setCode(200);
		response.setMessage("OK");
		response.setData(objectSrv.recoveryPassword(param));
		logging("success", "");
		return response;
	}
	
	@Override
	@ExceptionHandler
	public GeneralResponse handlerException(Exception e) {
		System.out.println("handlerException: " + e.getMessage() + "\n");
		setApiName("security-recoveryPassword");
		logging("error", e.getMessage());
		return new GeneralResponse(-200, e.getMessage());
	}
	
}
