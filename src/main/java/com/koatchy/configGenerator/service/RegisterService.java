/**
 * 
 */
package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.exception.RegisterException;
import com.koatchy.configGenerator.model.Register;

/**
 * @author alfredo.barrios
 *
 */
public interface RegisterService {
	
	Register add(Register user) throws RegisterException;
		
}
