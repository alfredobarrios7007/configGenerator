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
import com.koatchy.configGenerator.model.GetMyProfileRequest;
import com.koatchy.configGenerator.service.RegisterService;

/**
 * @author alfredo.barrios
 *
 */
@RequestMapping("/security")
@RestController
public class GetMyProfileController extends ServiceControllerImpl implements IServiceController {

	@Autowired
	RegisterService objectSrv;
	
	public GetMyProfileController() {
		super();
		setApiName("security-GetMyProfile");
	}

	/*
	 * This is the method implemented
	 */
	@CrossOrigin
	@RequestMapping(path = "GetMyProfile", method = RequestMethod.POST, produces = "application/JSON")
	@ResponseBody 
    public GeneralResponse getMyProfile(HttpServletRequest request, @RequestHeader("authentication") String authentication, @RequestBody final GetMyProfileRequest param)  throws Exception {
		System.out.print("updateMyProfile: " + param);
		setPlatform(param.getPlatform());
		setCaller(param.getCaller());
	    validateAuthorization(authentication);
		GeneralResponse response = new GeneralResponse();
		response.setCode(200);
		response.setMessage("OK");
		response.setData(objectSrv.get(param));		
		logging("success", "");
		return response;
    }

}
