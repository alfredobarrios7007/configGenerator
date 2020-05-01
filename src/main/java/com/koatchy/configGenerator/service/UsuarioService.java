package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.entity.*;
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
	
	void deleteRow(Long param);
	
}
