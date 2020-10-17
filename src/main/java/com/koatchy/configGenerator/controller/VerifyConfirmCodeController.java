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
import com.koatchy.configGenerator.model.VerifyCodeRequest;
import com.koatchy.configGenerator.service.RegisterService;

/**
 * @author alfredo.barrios
 *
 */
@RequestMapping("/security")
@RestController
public class VerifyConfirmCodeController extends ServiceControllerImpl implements IServiceController {

	@Autowired
	RegisterService objectSrv;
	
	public VerifyConfirmCodeController() {
		super();
		setApiName("security-VerifyConfirmCode");
	}
	
	@CrossOrigin
	@RequestMapping(path = "verifyRegister", method = RequestMethod.POST, produces = "application/JSON")
	public GeneralResponse verifyRegister(HttpServletRequest request, @RequestHeader("authentication") String authentication, @RequestBody final VerifyCodeRequest param) throws Exception {
		System.out.print("login " + param.toString() + "\n");
		setPlatform(param.getPlatform());
		setCaller(param.getCaller());
    /* The lines, below, get the origin of the called */
		//String origin = URI.create(request.getRequestURL().toString()).getHost();
	    //System.out.println(" Origin:" + origin);
	    validateAuthorization(authentication);
		GeneralResponse response = new GeneralResponse();
		response.setCode(200);
		response.setMessage("OK");
		response.setData(objectSrv.verifyConfirmCode(param));
		logging("success", "");
		return response;
	}
	
}
