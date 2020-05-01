/**
 * 
 */
package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.model.*;

/**
 * @author alfredo.barrios
 *
 */
public class LoginServiceImpl {
	public Boolean Login(Login param) {
		UsuarioService user;
		try {
			user = new UsuarioServiceImpl();
			
			
		} catch(Exception ex) {
			
		}
		return true;
	}
}
