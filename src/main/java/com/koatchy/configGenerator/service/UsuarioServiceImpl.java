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


@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired(required = true)
	private UsuarioDao objectDao;	
	
	@Override
	public Usuario save(Usuario param) {
		return objectDao.save(param);
	}

	@Override
	public Usuario update(Usuario param) {
		return objectDao.saveAndFlush(param);
	}

	@Override
	public List<Usuario> getAllRows() {
		return objectDao.findAll();
	}

	@Override
	public Optional<Usuario> getRow(Long param) {
		return objectDao.findById(param);
	}
	
	@Override
	public Optional<Usuario> getRowByUsernameAndPassword(Login param){
		return objectDao.findUserByNameAndPassword(param.getUsername(), EncryptUtil.encode("~KöAtcHy¬" + param.getUsername(), param.getPassword()));		
	}
	
	@Override
	public Optional<Usuario> findUserByEmail(String email){
		return objectDao.findUserByEmail(email);		
	}
	
	@Override
	public Boolean recoveryPassword(Login param) throws RecoveryPasswordException {
		Boolean result = false;
		
		if(param.getUsername().trim()=="") {
			throw new RecoveryPasswordException("EMPTY_EMAIL");
		}
		try {				
			Optional<Usuario> usuario = objectDao.findUserByEmail(param.getUsername());
			if (usuario.isPresent()) {
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
			throw new RecoveryPasswordException(e.getMessage());
		}
		return result;
	}
	
	@Override
	public Boolean setNewPassword(SetNewPassword param) throws SetNewPasswordException {
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
			throw new SetNewPasswordException(e.getMessage());
		}
		return result;
	}

	@Override
	public void deleteRow(Long param) {
		objectDao.deleteById(param);
	}

}
