/**
 * 
 */
package com.koatchy.configGenerator.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koatchy.configGenerator.entity.Usuario;
import com.koatchy.configGenerator.model.Login;
import com.koatchy.configGenerator.tools.Token;
import com.koatchy.configGenerator.exception.SecurityException;

/**
 * @author alfredo.barrios
 *
 */
@Service
public class SecurityServiceImpl implements SecurityService {
	
	@Autowired
	private UsuarioService serviceObj;
	
	public String validateCredentials(Login param) throws SecurityException {
		String result="";
		try {
			Token token = new Token("configGenerator");
			Optional<Usuario> usuario = null;
			usuario = serviceObj.getRowByUsernameAndPassword(param);
			if (usuario.isPresent())
				result = token.getToken(param);
			else
				throw new Exception("Las credenciales son incorrectas");
		} catch (Exception e) {
			throw new SecurityException(e.getMessage());
		}
		return result;
	}
}
