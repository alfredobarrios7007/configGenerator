package com.koatchy.configGenerator.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.koatchy.configGenerator.model.GeneralResponse;
import com.koatchy.configGenerator.model.RegisterRequest;
import com.koatchy.configGenerator.service.RegisterService;

/**
 * @author alfredo.barrios
 *
 */
@RequestMapping("/security")
@RestController
public class RegisterController extends ServiceControllerImpl implements IServiceController {

	@Autowired
	RegisterService objectSrv;
	
	public RegisterController() {
		super();
		setApiName("security-registerWithPhoto");
	}

	/*
	 * This is the method implemented
	 */
	@CrossOrigin
	@RequestMapping(path = "registerWithPhoto", method = RequestMethod.POST, produces = "application/JSON")
	@ResponseBody 
    public GeneralResponse registerWithPhoto(HttpServletRequest request, @RequestHeader("authentication") String authentication, @RequestParam(value = "inputPhoto") MultipartFile photo, 
    		@RequestParam("platform") String platform,
    		@RequestParam("caller") String caller,
    		@RequestParam("name") String name,
    		@RequestParam("lastname") String lastname,
    		@RequestParam("organization") String organization,
    		@RequestParam("area") String area,
    		@RequestParam("email") String email,
    		@RequestParam("password") String password
    		)  throws Exception {
		System.out.print("registerWithPhoto");
		setPlatform(platform);
		setCaller(caller);
	    validateAuthorization(authentication);
	    RegisterRequest param = new RegisterRequest(0L, name, lastname, organization, area, email, password, platform, caller, photo);
		System.out.print("registerWithPhoto: " + param);
		GeneralResponse response = new GeneralResponse();
		response.setCode(200);
		response.setMessage("OK");
		response.setData(objectSrv.add(param));		
		logging("success", "");
		return response;
    }
	
	/*
	 * This method deprecated
	 */
	@RequestMapping(path = "register", method = RequestMethod.POST, produces = "application/JSON")
	public GeneralResponse register(HttpServletRequest request, @RequestHeader("authentication") String authentication, @RequestBody final RegisterRequest param) throws Exception {
		System.out.print("register " + param.toString() + "\n");
		setApiName("security-register");
		setPlatform(param.getPlatform());
		setCaller(param.getCaller());
	    validateAuthorization(authentication);
		GeneralResponse response = new GeneralResponse();
		response.setCode(200);
		response.setMessage("OK");
		response.setData(objectSrv.add(param));		
		logging("success", "");
		return response;
	}



	/*
	 * This method deprecated
	 */
	@RequestMapping(path = "uploadUserPhoto", method = RequestMethod.POST, produces = "application/JSON")
	@ResponseBody 
    public GeneralResponse uploadUserPhoto(@RequestParam(value = "inputPhoto") MultipartFile photo, @RequestParam("iduser") Integer iduser) {
		System.out.print("uploadUserPhoto");
		GeneralResponse response = new GeneralResponse();
		response.setCode(200);
		response.setMessage("OK");
		System.out.print("uploadUserPhoto: " + photo.getName() + ", iduser: " + iduser + "\n");
		return response;
    }

}
