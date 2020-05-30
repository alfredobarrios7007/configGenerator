/**
 * 
 */
package com.koatchy.configGenerator.service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import org.hibernate.type.descriptor.java.DataHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koatchy.configGenerator.entity.Usuario;
import com.koatchy.configGenerator.model.Login;
import com.koatchy.configGenerator.model.VerifyChangePasswordCodeResult;
import com.koatchy.configGenerator.model.VerifyCode;
import com.koatchy.configGenerator.tools.DateHelper;
import com.koatchy.configGenerator.tools.Token;
import com.koatchy.configGenerator.tools.TypeElapsedTime;
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

	@Override
	public VerifyChangePasswordCodeResult VerifyChangePasswordCode(VerifyCode code) throws SecurityException {
		Token token = new Token("configGenerator");
		DateHelper dataH = new DateHelper();
		VerifyChangePasswordCodeResult result = new VerifyChangePasswordCodeResult();
		try {
			String decode = token.getRecoveryPasswordTokenDecrypt(code);
			String email = decode.split("|")[0];
			Date dateFromCode = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(decode.split("|")[1]);
			Date now = dataH.now(); 
			long minutesElpased = dataH.friendlyTimeDiff(TypeElapsedTime.Minute, dateFromCode, now);
			if(minutesElpased>5) {
				result.setResult(false);
				result.setMessage("TimeElapsed");
			}
		} catch (Exception e) {
			throw new SecurityException(e.getMessage());
		}
		return result;
	}

}
