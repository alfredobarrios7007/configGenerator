/**
 * 
 */
package com.koatchy.configGenerator.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.koatchy.configGenerator.model.GeneralResponse;
import com.koatchy.configGenerator.model.SetNewPasswordRequest;
import com.koatchy.configGenerator.service.SecurityService;

/**
 * @author alfredo.barrios
 *
 */
@RequestMapping("/security")
@RestController
public class SetPasswordController extends ServiceControllerImpl implements IServiceController {
	
	@Autowired
	SecurityService objectSrv;
	
	public SetPasswordController() {
		super();
		setApiName("security-SetNewPassword");
	}

	@CrossOrigin
	@RequestMapping(path = "SetNewPassword", method = RequestMethod.POST, produces = "application/JSON")
	public GeneralResponse setNewPassword(HttpServletRequest request, @RequestHeader("authentication") String authentication, @RequestBody final SetNewPasswordRequest param) throws Exception {
		System.out.print("setNewPassword " + param.toString() + "\n");
		setPlatform(param.getPlatform());
		setCaller(param.getCaller());
	    /* The lines, below, get the origin of the called */
		//String origin = URI.create(request.getRequestURL().toString()).getHost();
	    validateAuthorization(authentication);
		GeneralResponse response = new GeneralResponse();
		response.setCode(200);
		response.setMessage("OK");
		response.setData(objectSrv.setNewPassword(param));
		logging("success", "");
		return response;
	}

}
