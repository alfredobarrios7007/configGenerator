package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.entity.*;
import com.koatchy.configGenerator.exception.RecoveryPasswordException;
import com.koatchy.configGenerator.model.Login;

import java.util.List;
import java.util.Optional;


/**
 * @author alfredo.barrios
 *
 */
public interface UsuarioService {

	Usuario save(Usuario param);
	
	Usuario update(Usuario param);
	
	List<Usuario> getAllRows();
	
	Optional<Usuario> getRow(Long param);
	
	Optional<Usuario> getRowByUsernameAndPassword(Login param);
	
	Boolean recoveryPassword(Login param) throws RecoveryPasswordException; 
	
	void deleteRow(Long param);
	
}
