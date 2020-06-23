/**
 * 
 */
package com.koatchy.configGenerator.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.koatchy.configGenerator.model.GeneralResponse;
import com.koatchy.configGenerator.tools.DateHelper;
import com.koatchy.configGenerator.logging.*;

/**
 * @author alfredo.barrios
 *
 */
public class ServiceControllerImpl implements IServiceController {

	private String apiName;	
	private String platform;	
	private String caller;
	
	@Override
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	@Override
	public void setCaller(String caller) {
		this.caller = caller;
	}

	@Override
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	@Override
	public void validateAuthorization(String authentication) throws Exception  {
		if(!authentication.equals("wDo3rXrE/")) 
			throw new Exception("No está autorizado a usar este servicio");
	}
	
	@Override
	@ExceptionHandler
	public GeneralResponse handlerException(Exception e) {
		System.out.println("handlerException: " + e.getMessage() + "\n");
		logging("error", e.getMessage());
		return new GeneralResponse(-200, e.getMessage());
	}

	@Override
	public void logging(String successError, String errorMsg) {
		DateHelper dateH = new DateHelper();
		String logFile = apiName + "_" + dateH.getTodayStr() + ".cdr";		
		try 
		{
			String lineLogged = dateH.getNowStr() +"," + apiName + "," + successError + "," + platform + "," + caller + ", Error: " + errorMsg;
			ILogging loggging = new LoggingToCvsFile(logFile);
			loggging.writeLog(lineLogged);
		}
		catch (Exception err) {
			System.err.println("Exception ServiceController.logging thrown: " + err);
			//e.printStackTrace();
		}
		
	}

}
