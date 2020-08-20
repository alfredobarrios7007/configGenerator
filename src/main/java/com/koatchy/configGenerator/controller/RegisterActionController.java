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

import com.koatchy.configGenerator.model.ActionRegistered;
import com.koatchy.configGenerator.model.GeneralResponse;
import com.koatchy.configGenerator.service.RegisterActionService;

/**
 * @author alfredo.barrios
 *
 */
@RequestMapping("/statistics")
@RestController
public class RegisterActionController {

	@Autowired
	RegisterActionService objectSrv;

	@RequestMapping(path = "RegisterAction", method = RequestMethod.POST, produces = "application/JSON")
	public GeneralResponse register(HttpServletRequest request, @RequestHeader("authentication") String authentication, @RequestBody final ActionRegistered param) throws Exception {
		GeneralResponse response = new GeneralResponse();
		response.setCode(200);
		response.setMessage("OK");
		response.setData(objectSrv.register(param));		
		return response;
	}

}
