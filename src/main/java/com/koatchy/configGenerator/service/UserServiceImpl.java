package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.dao.*;
import com.koatchy.configGenerator.entity.*;
import com.koatchy.configGenerator.exception.RecoveryPasswordException;
import com.koatchy.configGenerator.exception.SetNewPasswordException;
import com.koatchy.configGenerator.model.EmailTemplate;
import com.koatchy.configGenerator.model.Login;
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
	public Optional<User> getRowByUsernameAndPassword(Login param){
		System.out.print("UserServiceImpl getRowByUsernameAndPassword param: " + param.toString() + "\n");
		return objectDao.findUserByNameAndPassword(param.getUsername(), param.getPassword());		
	}
	
	@Override
	public Optional<User> findUserByEmail(String email){
		System.out.print("UserServiceImpl findUserByEmail param: " + email + "\n");
		return objectDao.findUserByEmail(email);
	}
	
	@Override
	public Boolean recoveryPassword(Login param) throws RecoveryPasswordException {
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
				EmailTemplate emailTemp = new EmailTemplate();
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
			System.out.print("Error recoveryPassword\n");
			throw new RecoveryPasswordException(e.getMessage());
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
