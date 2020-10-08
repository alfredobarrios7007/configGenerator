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

import com.koatchy.configGenerator.model.GeneralRequest;
import com.koatchy.configGenerator.model.GeneralResponse;
import com.koatchy.configGenerator.service.OrganizationsService;

/**
 * @author alfredo.barrios
 *
 */
@RequestMapping("/catlogs")
@RestController
public class OrganizationsController extends ServiceControllerImpl implements IServiceController {

	@Autowired
	OrganizationsService objectSrv;
	
	public OrganizationsController() {
		super();
		setApiName("catalogs-getAllOrganizations");
	}
	
	@CrossOrigin
	@RequestMapping(path = "getAllOrganizations", method = RequestMethod.POST, produces = "application/JSON")
	public GeneralResponse getAllOrganizations(HttpServletRequest request, @RequestHeader("authentication") String authentication, @RequestBody final GeneralRequest param) throws Exception {
		System.out.print("getAllOrganizations: " + param.toString() + "\n");
		setPlatform(param.getPlatform());
		setCaller(param.getCaller());
	    /* The lines, below, get the origin of the called */
		//String origin = URI.create(request.getRequestURL().toString()).getHost();
	    //System.out.println(" Origin:" + origin);
	    validateAuthorization(authentication);
		GeneralResponse response = new GeneralResponse();
		response.setCode(200);
		response.setMessage("OK");
		response.setData(objectSrv.getAllRows());		
		logging("success", "");
		return response;
	}
	
}
