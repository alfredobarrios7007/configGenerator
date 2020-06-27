package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.entity.User;
import com.koatchy.configGenerator.exception.RecoveryPasswordException;
import com.koatchy.configGenerator.exception.SetNewPasswordException;
import com.koatchy.configGenerator.model.LoginRequest;
import com.koatchy.configGenerator.model.SetNewPassword;

import java.util.List;
import java.util.Optional;


/**
 * @author alfredo.barrios
 *
 */
public interface UserService {

	User save(User param);
	
	User update(User param);
	
	Boolean setNewPassword(SetNewPassword param) throws SetNewPasswordException; 
	
	List<User> getAllRows();
	
	Optional<User> getRow(Long param);
	
	Optional<User> findUserByEmail(String email);
	
	Optional<User> getRowByUsernameAndPassword(LoginRequest param);
	
	Boolean recoveryPassword(LoginRequest param) throws RecoveryPasswordException; 
	
	void deleteRow(Long param);
	
}
