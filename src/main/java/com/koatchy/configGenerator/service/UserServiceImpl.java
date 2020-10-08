package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.dao.*;
import com.koatchy.configGenerator.entity.*;
import com.koatchy.configGenerator.exception.RecoveryPasswordException;
import com.koatchy.configGenerator.exception.SetNewPasswordException;
import com.koatchy.configGenerator.model.EmailTemplate;
import com.koatchy.configGenerator.model.LoginRequest;
import com.koatchy.configGenerator.model.SetNewPassword;
import com.koatchy.configGenerator.tools.EncryptUtil;
import com.koatchy.configGenerator.tools.Token;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author alfredo.barrios
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired(required = true)
	private UsersDao objectDao;	

	@Autowired(required = true)
	ConfigurationsService configSrv;
	
	@Override
	public User save(User param) {
		System.out.print("UserServiceImpl save param: " + param.toString() + "\n");
		return objectDao.save(param);
	}

	@Override
	public User update(User param) {
		System.out.print("UserServiceImpl update param: " + param.toString() + "\n");
		return objectDao.saveAndFlush(param);
	}

	@Override
	public List<User> getAllRows() {
		System.out.print("UserServiceImpl getAllRows\n");
		return objectDao.findAll();
	}

	@Override
	public Optional<User> getRow(Long param) {
		System.out.print("UserServiceImpl getRow param: " + param + "\n");
		return objectDao.findById(param);
	}
	
	@Override
	public Optional<User> getRowByUsernameAndPassword(LoginRequest param){
		System.out.print("UserServiceImpl getRowByUsernameAndPassword param: " + param.toString() + "\n");
		return objectDao.findUserByNameAndPassword(param.getUsername(), param.getPassword());		
	}
	
	@Override
	public Optional<User> findUserByEmail(String email){
		System.out.print("UserServiceImpl findUserByEmail param: " + email + "\n");
		return objectDao.findUserByEmail(email);
	}
	
	private EmailTemplate fillEmailTemplate() {
		String host = "";
		Integer port = 0;
		String from = "";
		String subject = "";
		String message = "";
		System.out.print("fillEmailTemplate 1\n");
		Optional<Configuration> rowCnf1 = configSrv.findByDescription("RecoveryPwdHost");
		System.out.print("fillEmailTemplate 2\n");
		Optional<Configuration> rowCnf2 = configSrv.findByDescription("RecoveryPwdPort");
		System.out.print("fillEmailTemplate 3\n");
		Optional<Configuration> rowCnf3 = configSrv.findByDescription("RecoveryPwdFrom");
		System.out.print("fillEmailTemplate 4\n");
		Optional<Configuration> rowCnf4 = configSrv.findByDescription("RecoveryPwdSubject");
		System.out.print("fillEmailTemplate 5\n");
		Optional<Configuration> rowCnf5 = configSrv.findByDescription("RecoveryPwdMessage");
		if(rowCnf1.isPresent()) {
			host = rowCnf1.get().getValueOf();
		}
		if(rowCnf2.isPresent()) {
			port = Integer.parseInt(rowCnf2.get().getValueOf());
		}
		if(rowCnf3.isPresent()) {
			from = rowCnf3.get().getValueOf();
		}
		if(rowCnf4.isPresent()) {
			subject = rowCnf4.get().getValueOf();
		}
		if(rowCnf5.isPresent()) {
			message = rowCnf5.get().getValueOf();
		}
		return new EmailTemplate(host,port,from,"",subject,message);
	}
	
	@Override
	public Boolean recoveryPassword(LoginRequest param) throws RecoveryPasswordException {
		System.out.print("UserServiceImpl recoveryPassword param: " + param.toString() + "\n");
		Boolean result = false;
		
		if(param.getUsername().trim()=="") {
			throw new RecoveryPasswordException("EMPTY_EMAIL");
		}
		try {				
			Optional<User> user = objectDao.findUserByEmail(param.getUsername());
			if (user.isPresent()) {
				result = true;
				//Send e-mail
				System.out.print("UserServiceImpl recoveryPassword 1\n");
				EmailTemplate emailTemp = fillEmailTemplate();
				System.out.print("UserServiceImpl recoveryPassword 2\n");
				emailTemp.setTo(param.getUsername());
				String msg = emailTemp.getMessage();
				Token tokn = new Token("~KöAtcHy¬");
				msg += tokn.getRecoveryPasswordToken(param.getUsername());
				emailTemp.setMessage(msg);
				System.out.print(msg);
				/* NEED UNCOMMENT THE FOLLOW LINES */
				//EmailHelper emailH = new EmailHelper();
				//emailH.sendmail(emailTemp);
			}else {
				result = false;
			}
		} catch (Exception e) {
			System.out.print("Error recoveryPassword: " + e + "\n");
			throw new RecoveryPasswordException("WRONG_ACCOUNT");
		}
		return result;
	}
	
	@Override
	public Boolean setNewPassword(SetNewPassword param) throws SetNewPasswordException {
		System.out.print("UserServiceImpl setNewPassword param: " + param.toString() + "\n");
		Boolean result = true;
		
		try {
			if(param.getEmail().trim()=="") {
				throw new Exception("EMPTY_EMAIL");
			}
			
			if(param.getNewPassword().trim()=="") {
				throw new Exception("EMPTY_PASSWORD");
			}
			String ePwd = EncryptUtil.encode("~KöAtcHy¬" + param.getEmail(), param.getNewPassword());
			int count = objectDao.setNewPassword(param.getEmail(), ePwd);
			System.out.print("ePwd: " + ePwd + ", count: " + count);
		} catch (Exception e) {
			System.out.print("Error setNewPassword\n");
			throw new SetNewPasswordException(e.getMessage());
		}
		return result;
	}

	@Override
	public void deleteRow(Long param) {
		System.out.print("UserServiceImpl deleteRow param: " + param + "\n");
		objectDao.deleteById(param);
	}

}
