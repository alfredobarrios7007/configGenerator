/**
 * 
 */
package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.exception.*;
import com.koatchy.configGenerator.model.*;

/**
 * @author alfredo.barrios
 *
 */
public interface RegisterService {
	
	RegisterRequest add(RegisterRequest user) throws RegisterException;
	
	RegisterRequest modify(RegisterRequest user) throws RegisterException;
	
	RegisterRequest get(GetMyProfileRequest user) throws GetMyProfileException;
	
	RegisterConfirmReponse verifyConfirmCode(VerifyCodeRequest code) throws RegisterConfirmException;
	
}
