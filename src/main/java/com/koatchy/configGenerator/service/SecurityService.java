/**
 * 
 */
package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.exception.SecurityException;
import com.koatchy.configGenerator.model.Login;

/**
 * @author alfredo.barrios
 *
 */
public interface SecurityService {
	
	String validateCredentials(Login param) throws SecurityException;

}
