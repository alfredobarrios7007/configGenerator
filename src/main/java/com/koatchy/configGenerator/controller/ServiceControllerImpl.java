/**
 * 
 */
package com.koatchy.configGenerator.controller;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.ExceptionHandler;

import com.koatchy.configGenerator.model.GeneralResponse;

import com.koatchy.configGenerator.tools.DateHelper;

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
		System.out.println("handlerException: " + e.getMessage());
		logging("error", e.getMessage());
		return new GeneralResponse(-200, e.getMessage());
	}
	

	@Override
	public void logging(String successError, String errorMsg) {
		DateHelper dateH = new DateHelper();
		//String pathLog ="c:/cdr/configGenerator/" + apiName + "_" + dateH.getTodayStr() + ".cdr";		
		String pathLog ="/cdr/configGenerator/" + apiName + "_" + dateH.getTodayStr() + ".cdr";		
		try 
		{
			System.out.print("logging 1\n");
			LogManager lm = LogManager.getLogManager();
			System.out.print("logging 2\n");
			Logger logger = Logger.getLogger("BasicLogging");
			System.out.print("logging 3\n");
			FileHandler fh = new FileHandler(pathLog);
			System.out.print("logging 4\n");
			lm.addLogger(logger);
			System.out.print("logging 5\n");
			logger.addHandler(fh);
			String lineLogged = dateH.getNowStr() +"," + apiName + "," + successError + "," + platform + "," + caller + ", Error: " + errorMsg;
			System.out.print("logging 6: " + lineLogged + "\n");
			logger.log(Level.INFO, lineLogged );
			fh.close();
		}
		catch (Exception e) {
			System.err.println("Exception logging thrown: " + e);
			e.printStackTrace();
		}
		
	}

}
