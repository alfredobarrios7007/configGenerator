/**
 * 
 */
package com.koatchy.configGenerator.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koatchy.configGenerator.exception.RegisterException;
import com.koatchy.configGenerator.model.Register;
import com.koatchy.configGenerator.tools.EncryptUtil;
import com.koatchy.configGenerator.dao.RegisterStoredProcDao;
import com.koatchy.configGenerator.entity.User;

/**
 * @author alfredo.barrios
 * It class register user and modify user data
 */
@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	RegisterStoredProcDao registerDao;
	
	@Override
	public Register add(Register user) throws RegisterException {
		System.out.print("RegisterServiceImpl add 0\n");
		String ePwd = EncryptUtil.encode("~KöAtcHy¬" + user.getEmail(), user.getPassword());
		System.out.print("RegisterServiceImpl add 1: " + user.getPassword() + " | " + ePwd + " \n");
		System.out.print("RegisterServiceImpl add 2: " + user.toString() + " \n");
		registerDao.register(user.getPlatform(), user.getName(), user.getLastname(), user.getOrganization(), user.getArea(), user.getEmail(), ePwd);
		System.out.print("RegisterServiceImpl add 3: " + user.getEmail() + " \n");
		UserService usrSrv = new UserServiceImpl();
		Optional<User> usr = usrSrv.findUserByEmail(user.getEmail());
		if (usr.isPresent()) {
			System.out.print("RegisterServiceImpl add 4: " + usr.get().getId() + "\n");
			user.setId(usr.get().getId());			
		}
		System.out.print(user.toString());
		return user;
	}
	
}
