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
import com.koatchy.configGenerator.entity.UserArea;
import com.koatchy.configGenerator.entity.Organization;
import com.koatchy.configGenerator.model.LoginRequest;
import com.koatchy.configGenerator.model.SecurityResult;
import com.koatchy.configGenerator.model.SetNewPasswordRequest;
import com.koatchy.configGenerator.model.TokenRequest;
import com.koatchy.configGenerator.model.TokenResponse;
import com.koatchy.configGenerator.model.SetNewPassword;
import com.koatchy.configGenerator.model.VerifyCodeRequest;
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
	
	@Autowired
	private UserAreasService userAreaSrvObj;
	
	@Autowired
	private OrganizationsService orgsSrvObj;

	/**
	 * Check session and return user common values
	 */
	@Override
	public TokenResponse checkSessionToken(TokenRequest param) throws SecurityException {
		System.out.print("checkSessionToken " + param.toString() + "\n");
		Token token = new Token("configGenerator");
		TokenResponse result = new TokenResponse();
		try {
			String[] decryptedTkn = token.getDeryptedToken(param);	
			Optional<User> user = serviceObj.getRowByUsernameAndPassword(new LoginRequest(param.getPlatform(), param.getCaller(), decryptedTkn[3], decryptedTkn[4]));
			if (user.isPresent()){
				result.setName(user.get().getName());
				result.setLastname(user.get().getLastname());
				result.setSuperuser(user.get().getSuperuser());
				// Set user area
				if(user.get().getIdUserArea()!=null) {
					Optional<UserArea> userArea = userAreaSrvObj.getRow(user.get().getIdUserArea());
					if(userArea.isPresent()) {
						result.setAreaname(userArea.get().getName());					
					}
				}
				// Set organization
				if(user.get().getIdUserArea()!=null) {
					Optional<Organization> orgz = orgsSrvObj.getRow(user.get().getIdUserArea());
					if(orgz.isPresent()) {
						result.setOrganizationName(orgz.get().getName());					
					}
				}
			}else {
				System.out.print("WRONG_CREDENTIALS");
				throw new Exception("CREDENTIALS_NO_LONGER_VALID");
			}
		} catch (Exception e) {
			System.out.print("Error validateCredentials\n");
			throw new SecurityException(e.getMessage());
		}
		return result;
	}
	
	@Override
	public String validateCredentials(LoginRequest param) throws SecurityException {
		System.out.print("validateCredentials " + param.toString() + "\n");
		String result="";
		try {
			Token token = new Token("configGenerator");
			String ePwd = EncryptUtil.encode("~KöAtcHy¬" + param.getUsername(), param.getPassword());
			param.setPassword(ePwd);
			System.out.print("validateCredentials 2 " + param.toString() + "\n");
			Optional<User> user = serviceObj.getRowByUsernameAndPassword(param);
			if (user.isPresent())
				result = token.getToken(param);
			else {
				System.out.print("WRONG_CREDENTIALS");
				throw new Exception("WRONG_CREDENTIALS");
			}
		} catch (Exception e) {
			System.out.print("Error validateCredentials\n");
			throw new SecurityException(e.getMessage());
		}
		return result;
	}

	@Override
	public SecurityResult verifyChangePasswordCode(VerifyCodeRequest code) throws SecurityException {
		System.out.print("verifyChangePasswordCode " + code.toString() + "\n");
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
			System.out.print("Error verifyChangePasswordCode\n");
			throw new SecurityException(e.getMessage());
		}
		return result;
	}

	@Override
	public SecurityResult setNewPassword(SetNewPasswordRequest param) throws SecurityException {
		System.out.print("setNewPassword " + param.toString() + "\n");
		Token token = new Token("configGenerator");
		DateHelper dataH = new DateHelper();
		SecurityResult result = new SecurityResult();
		try {			
			String decode = token.verifyChangePasswordCode(new VerifyCodeRequest(param.getCode()));
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
			System.out.print("Error setNewPassword " + e.toString() + "\n");
			throw new SecurityException(e.getMessage());
		}
		return result;
	}

}
