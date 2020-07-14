/**
 * 
 */
package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.exception.RegisterException;
import com.koatchy.configGenerator.model.RegisterRequest;

/**
 * @author alfredo.barrios
 *
 */
public interface RegisterService {
	
	RegisterRequest add(RegisterRequest user) throws RegisterException;
		
}
