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
import com.koatchy.configGenerator.dao.UsersDao;
import com.koatchy.configGenerator.entity.User;

/**
 * @author alfredo.barrios
 * It class register user and modify user data
 */
@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired(required = true)
	RegisterStoredProcDao registerDao;
	
	@Autowired(required = true)
	private UsersDao objectDao;	
	
	
	@Override
	public Register add(Register user) throws RegisterException {
		System.out.print("RegisterServiceImpl add 0\n");
		try {
			String ePwd = EncryptUtil.encode("~KöAtcHy¬" + user.getEmail(), user.getPassword());
			System.out.print("RegisterServiceImpl add 1: " + user.getPassword() + " | " + ePwd + " \n");
			System.out.print("RegisterServiceImpl add 2: " + user.toString() + " \n");
			registerDao.register(user.getPlatform(), user.getName(), user.getLastname(), user.getOrganization(), user.getArea(), user.getEmail(), ePwd);
			System.out.print("RegisterServiceImpl add 3: " + user.getEmail() + " \n");
			Optional<User> usr = objectDao.findUserByEmail(user.getEmail());
			System.out.print("RegisterServXiceImpl add 4: " + usr.isPresent() + "\n");
			if (usr.isPresent()) {
				System.out.print("RegisterServiceImpl add 5: " + usr.get().getId() + "\n");
				user.setId(usr.get().getId());			
			}
			System.out.print("RegisterServiceImpl add 6: " + user.toString() + "\n");
			user.setPhoto(null);
		} catch (Exception e) {
			System.out.print("ERROR RegisterServiceImpl add: " + e.toString() + "\n");
			throw e;
		}
		return user;
	}
	
}
