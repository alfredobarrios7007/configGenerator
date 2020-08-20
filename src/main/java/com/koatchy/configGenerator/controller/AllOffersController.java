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

import com.koatchy.configGenerator.model.GeneralRequest;
import com.koatchy.configGenerator.model.GeneralResponse;
import com.koatchy.configGenerator.service.OffersService;

/**
 * @author alfredo.barrios
 *
 */
@RequestMapping("/offers")
@RestController
public class AllOffersController extends ServiceControllerImpl implements IServiceController {
	@Autowired
	OffersService objectSrv;
	
	public AllOffersController() {
		super();
		setApiName("offers-getAllOffers");
	}

	@RequestMapping(path = "getSubscriptionByUser", method = RequestMethod.POST, produces = "application/JSON")
	public GeneralResponse getAllOffers(HttpServletRequest request, @RequestHeader("authentication") String authentication, @RequestBody final GeneralRequest param) throws Exception {
		System.out.print("getAllOffers: " + param.toString() + "\n");
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
