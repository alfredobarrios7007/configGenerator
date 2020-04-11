package com.koatchy.configGenerator.service;

import java.util.List;
import java.util.Optional;

import com.koatchy.configGenerator.entity.UsuarioArea;

/**
 * @author alfredo.barrios
 *
 */
public interface UsuarioAreaService {

	UsuarioArea saveUsuarioArea(UsuarioArea usuario);
	
	UsuarioArea updateUsuarioArea(UsuarioArea usuario);
	
	List<UsuarioArea> getAllUsuarioAreas();
	
	Optional<UsuarioArea> getUsuarioArea(Long IdUsuarioArea);
	
	void deleteUsuarioArea(Long IdUsuarioArea);

}
