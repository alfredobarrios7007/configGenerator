package com.koatchy.configGenerator.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koatchy.configGenerator.model.GeneralResponse;
import com.koatchy.configGenerator.model.GetInitialDataRequest;
import com.koatchy.configGenerator.model.KeyValue;
import com.koatchy.configGenerator.service.InitialIDDataService;
import com.koatchy.configGenerator.service.InitialIDDataServiceImpl;

@RequestMapping("InitData")
@RestController
public class GetInitialIDDataController implements ServiceController {

	@PostMapping("getInitialIDData")
	public GeneralResponse getInitialIDData(@RequestHeader("x-nokia-msisdn") String xNokiaMsisdn, @RequestBody GetInitialDataRequest params) 
	{
		GeneralResponse response = new GeneralResponse();
		response.setCode(200);
		response.setMessage("OK");
		InitialIDDataService iIDData = new InitialIDDataServiceImpl();
		String codedMsidn = iIDData.GetMsisdnEncrypted(params, xNokiaMsisdn);
		System.out.println("codedMsidn: " + codedMsidn);
		response.setData(codedMsidn);
		return response;
	}

	@PostMapping("testTest")
	public GeneralResponse testTest(@RequestBody KeyValue param) 
	{
		GeneralResponse response = new GeneralResponse(200, "OK", param);
		return response;
	}

	@Override
	@ExceptionHandler
	public GeneralResponse handlerException(Exception e) {
		System.out.println(e.toString());
		return new GeneralResponse(-200, "Error: " + e.toString());
	}

	@Override
	public void validateAuthorization(String authentication) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
}
