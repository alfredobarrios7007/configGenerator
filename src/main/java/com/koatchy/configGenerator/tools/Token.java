package com.koatchy.configGenerator.tools;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.koatchy.configGenerator.model.Login;
import com.koatchy.configGenerator.model.VerifyCode;

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

	public String verifyChangePasswordCode(VerifyCode code) throws Exception {
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
	
	public String getToken(Login credentials) throws Exception {
		String result = "";
		try {
			result = EncryptUtil.encode("~KöAtcHy¬", generateTokenString(credentials));
		} catch (Exception e) {
			throw new Exception("Not possible generate a token in this moment.");
		}
		return result;
	}
	
	public Boolean validateToken() {
		Boolean result=true;
		return result;
		
	} 
	
	private String generateTokenString(Login credentials) {
		String result = product + "|" + getCurrentDate() + "|5TH|" + credentials.getUsername() + "|" + credentials.getPassword() ;

		
		return result;
	}
	
	private String getCurrentDate() {    
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();  
		return dtf.format(now);
	}
}
