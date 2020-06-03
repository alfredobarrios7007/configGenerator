/**
 * 
 */
package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.exception.SecurityException;
import com.koatchy.configGenerator.model.Login;
import com.koatchy.configGenerator.model.VerifyChangePasswordCodeResult;
import com.koatchy.configGenerator.model.VerifyCode;

/**
 * @author alfredo.barrios
 *
 */
public interface SecurityService {
	
	String validateCredentials(Login param) throws SecurityException;

	VerifyChangePasswordCodeResult verifyChangePasswordCode(VerifyCode code) throws SecurityException; 
	
}
