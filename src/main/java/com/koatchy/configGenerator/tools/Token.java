package com.koatchy.configGenerator.tools;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.koatchy.configGenerator.model.LoginRequest;
import com.koatchy.configGenerator.model.TokenRequest;
import com.koatchy.configGenerator.model.TokenResponse;
import com.koatchy.configGenerator.model.VerifyCodeRequest;

public class Token {
	
	private String product;
	
	public String getRecoveryPasswordToken(String email) throws Exception {
		String result = "";
		try {
			result = EncryptUtil.encode("~KöAtcHy¬", email + "|" + getCurrentDate()).replace("+", "¬");
		} catch (Exception e) {
			throw new Exception("Not possible generate a token in this moment.");
		}
		return result;
	}

	public String verifyChangePasswordCode(VerifyCodeRequest code) throws Exception {
		String result = "";
		try {
			result = EncryptUtil.decode("~KöAtcHy¬", code.getCode().replace("¬","+"));
		} catch (Exception e) {
			throw new Exception("Not possible generate a token in this moment.");
		}
		return result;
	}
	
	
	public Token(String product) {
		this.product = product;
	}
	
	public String getToken(LoginRequest param) throws Exception {
		String result = "";
		try {
			result = EncryptUtil.encode("~KöAtcHy¬", generateTokenString(param));
		} catch (Exception e) {
			throw new Exception("ERROR_GENERATING_TOKEN");
		}
		return result;
	}
	
	public String[] getDeryptedToken(TokenRequest param) throws Exception {
		String[] result = {};
		try {
			if(param.getToken().trim()=="") 
				throw new Exception("NO_VALID_SESSION");

			String tokenDecrypted = EncryptUtil.decode("~KöAtcHy¬", param.getToken());
			if(tokenDecrypted.trim()=="") 
				throw new Exception("NO_VALID_SESSION");
			
			result = tokenDecrypted.split("|");
			if(result[0]!=product||result[2]!="5TH") 
				throw new Exception("NO_VALID_SESSION");
			
		} catch (Exception e) {
			throw new Exception("NO_VALID_SESSION");
		}
		return result;
		
	} 
	
	private String generateTokenString(LoginRequest param) {
		String result = product + "|" + getCurrentDate() + "|5TH|" + param.getUsername() + "|" + param.getPassword() ;		
		return result;
	}
	
	private String getCurrentDate() {    
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();  
		return dtf.format(now);
	}
}
