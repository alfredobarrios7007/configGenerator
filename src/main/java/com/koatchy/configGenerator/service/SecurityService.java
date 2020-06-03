/**
 * 
 */
package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.exception.SecurityException;
import com.koatchy.configGenerator.model.Login;
import com.koatchy.configGenerator.model.SecurityResult;
import com.koatchy.configGenerator.model.SetNewPasswordRequest;
import com.koatchy.configGenerator.model.VerifyCode;

/**
 * @author alfredo.barrios
 *
 */
public interface SecurityService {
	
	String validateCredentials(Login param) throws SecurityException;

	SecurityResult verifyChangePasswordCode(VerifyCode code) throws SecurityException; 
	
	SecurityResult setNewPassword(SetNewPasswordRequest param) throws SecurityException; 
	
}
