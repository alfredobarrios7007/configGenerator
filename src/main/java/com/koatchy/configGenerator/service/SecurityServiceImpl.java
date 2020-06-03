/**
 * 
 */
package com.koatchy.configGenerator.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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
			else {
				System.out.print("WRONG_CREDENTIALS");
				throw new Exception("WRONG_CREDENTIALS");
			}
		} catch (Exception e) {
			throw new SecurityException(e.getMessage());
		}
		return result;
	}

	@Override
	public VerifyChangePasswordCodeResult verifyChangePasswordCode(VerifyCode code) throws SecurityException {
		Token token = new Token("configGenerator");
		DateHelper dataH = new DateHelper();
		VerifyChangePasswordCodeResult result = new VerifyChangePasswordCodeResult();
		Optional<Usuario> usuario = null;
		try {
			String decode = token.verifyChangePasswordCode(code);
			System.out.print("decode : " + decode + "\n");
			//List<String> stringList = Pattern.compile("|").splitAsStream(decode).collect(Collectors.toList());
			String stringList[] = decode.split("\\|");
			String email = stringList[0];//stringList.get(0);
			String dateExpire = stringList[1];//stringList.get(1);
			System.out.print("email: " + email + ", date: "+ dateExpire + ", count: "+ stringList.length + "\n");
			usuario = serviceObj.findUserByEmail(email);
			if (!usuario.isPresent()) {
				System.out.print("EMAIL_NOT_FOUND");
				throw new Exception("EMAIL_NOT_FOUND");
			}
			Date dateFromCode = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(dateExpire);
			Date now = dataH.now(); 
			long minutesElpased = dataH.friendlyTimeDiff(TypeElapsedTime.Minute, dateFromCode, now);
			if(minutesElpased>5) {
				System.out.print("ELAPSED_TIME");
				throw new Exception("ELAPSED_TIME");
			}
			result.setResult(true);
			result.setMessage("SUCCESS");
			System.out.print("EVERYTHING ALRIGHT");
		} catch (Exception e) {
			throw new SecurityException(e.getMessage());
		}
		return result;
	}

}
