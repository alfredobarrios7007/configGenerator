/**
 * 
 */
package com.koatchy.configGenerator.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koatchy.configGenerator.entity.User;
import com.koatchy.configGenerator.model.Login;
import com.koatchy.configGenerator.model.SecurityResult;
import com.koatchy.configGenerator.model.SetNewPasswordRequest;
import com.koatchy.configGenerator.model.SetNewPassword;
import com.koatchy.configGenerator.model.VerifyCode;
import com.koatchy.configGenerator.tools.DateHelper;
import com.koatchy.configGenerator.tools.EncryptUtil;
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
	private UserService serviceObj;
	
	@Override
	public String validateCredentials(Login param) throws SecurityException {
		String result="";
		try {
			Token token = new Token("configGenerator");
			System.out.print("validateCredentials 1: " + param.toString());
			String ePwd = EncryptUtil.encode("~KöAtcHy¬" + param.getUsername(), param.getPassword());
			param.setPassword(ePwd);
			System.out.print("validateCredentials 2: " + param.toString());
			Optional<User> user = serviceObj.getRowByUsernameAndPassword(param);
			if (user.isPresent())
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
	public SecurityResult verifyChangePasswordCode(VerifyCode code) throws SecurityException {
		Token token = new Token("configGenerator");
		DateHelper dataH = new DateHelper();
		SecurityResult result = new SecurityResult();
		try {
			String decode = token.verifyChangePasswordCode(code);
			//List<String> stringList = Pattern.compile("|").splitAsStream(decode).collect(Collectors.toList());
			String stringList[] = decode.split("\\|");
			String email = stringList[0];//stringList.get(0);
			String dateExpire = stringList[1];//stringList.get(1);
			Optional<User> user = serviceObj.findUserByEmail(email);
			if (!user.isPresent()) {
				throw new Exception("EMAIL_NOT_FOUND");
			}
			Date dateFromCode = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(dateExpire);
			Date now = dataH.now(); 
			long minutesElpased = dataH.friendlyTimeDiff(TypeElapsedTime.Minute, dateFromCode, now);
			if(minutesElpased>20) {
				throw new Exception("ELAPSED_TIME");
			}
			result.setResult(true);
			result.setMessage("SUCCESS");
		} catch (Exception e) {
			throw new SecurityException(e.getMessage());
		}
		return result;
	}

	@Override
	public SecurityResult setNewPassword(SetNewPasswordRequest param) throws SecurityException {
		Token token = new Token("configGenerator");
		DateHelper dataH = new DateHelper();
		SecurityResult result = new SecurityResult();
		try {			
			String decode = token.verifyChangePasswordCode(new VerifyCode(param.getCode()));
			//List<String> stringList = Pattern.compile("|").splitAsStream(decode).collect(Collectors.toList());
			String stringList[] = decode.split("\\|");
			String email = stringList[0];//stringList.get(0);
			String dateExpire = stringList[1];//stringList.get(1);
			Optional<User> user = serviceObj.findUserByEmail(email);
			if (!user.isPresent()) {
				throw new Exception("EMAIL_NOT_FOUND");
			}
			Date dateFromCode = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(dateExpire);
			Date now = dataH.now(); 
			long minutesElpased = dataH.friendlyTimeDiff(TypeElapsedTime.Minute, dateFromCode, now);
			if(minutesElpased>8) {
				throw new Exception("ELAPSED_TIME");
			}
			SetNewPassword snp = new SetNewPassword(email, param.getNewPassword());			
			result.setResult(serviceObj.setNewPassword(snp));
			result.setMessage("SUCCESS");
		} catch (Exception e) {
			throw new SecurityException(e.getMessage());
		}
		return result;
	}

}
