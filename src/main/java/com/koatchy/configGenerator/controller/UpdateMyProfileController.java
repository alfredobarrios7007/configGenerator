package com.koatchy.configGenerator.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.koatchy.configGenerator.model.GeneralResponse;
import com.koatchy.configGenerator.model.RegisterRequest;
import com.koatchy.configGenerator.service.RegisterService;

/**
 * @author alfredo.barrios
 *
 */
@RequestMapping("/security")
@RestController
public class UpdateMyProfileController extends ServiceControllerImpl implements IServiceController {

	@Autowired
	RegisterService objectSrv;
	
	public UpdateMyProfileController() {
		super();
		setApiName("security-UpdateMyProfile");
	}

	/*
	 * Update the profile
	 */
	@CrossOrigin
	@RequestMapping(path = "UpdateMyProfile", method = RequestMethod.POST, produces = "application/JSON")
	@ResponseBody 
    public GeneralResponse UpdateMyProfile(HttpServletRequest request, @RequestHeader("authentication") String authentication,  
    		@RequestBody final RegisterRequest param
    		)  throws Exception {
		System.out.print("registerWithPhoto");
		setPlatform(param.getPlatform());
		setCaller(param.getCaller());
	    validateAuthorization(authentication);
		System.out.print("registerWithPhoto: " + param);
		GeneralResponse response = new GeneralResponse();
		response.setCode(200);
		response.setMessage("OK");
		response.setData(objectSrv.modify(param));		
		logging("success", "");
		return response;
    }

}
