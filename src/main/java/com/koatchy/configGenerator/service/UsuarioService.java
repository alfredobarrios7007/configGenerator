package com.koatchy.configGenerator.service;

import java.util.List;
import java.util.Optional;

import com.koatchy.configGenerator.entity.Usuario;

/**
 * @author alfredo.barrios
 *
 */
public interface UsuarioService {

	Usuario saveUsuario(Usuario usuario);
	
	Usuario updateUsuario(Usuario usuario);
	
	List<Usuario> getAllUsuarios();
	
	Optional<Usuario> getUsuario(Long IdUsuario);
	
	void deleteUsuario(Long IdUsuario);
	
}
