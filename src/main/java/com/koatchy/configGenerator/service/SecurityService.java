/**
 * 
 */
package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.exception.SecurityException;
import com.koatchy.configGenerator.model.LoginRequest;
import com.koatchy.configGenerator.model.SecurityResult;
import com.koatchy.configGenerator.model.SetNewPasswordRequest;
import com.koatchy.configGenerator.model.TokenRequest;
import com.koatchy.configGenerator.model.TokenResponse;
import com.koatchy.configGenerator.model.VerifyCodeRequest;

/**
 * @author alfredo.barrios
 *
 */
public interface SecurityService {
	
	TokenResponse checkSessionToken(TokenRequest param) throws SecurityException;
	
	String validateCredentials(LoginRequest param) throws SecurityException;

	SecurityResult verifyChangePasswordCode(VerifyCodeRequest code) throws SecurityException; 
	
	SecurityResult setNewPassword(SetNewPasswordRequest param) throws SecurityException; 
	
}
