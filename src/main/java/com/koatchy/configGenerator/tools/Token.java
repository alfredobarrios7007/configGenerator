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
	
	public TokenResponse validateToken(TokenRequest param) throws Exception {
		TokenResponse result = new TokenResponse();
		try {
			//TODO: Login to validate token
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
