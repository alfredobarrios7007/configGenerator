package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.entity.UsuarioAreas;
import java.util.List;
import java.util.Optional;


/**
 * @author alfredo.barrios
 *
 */
public interface UsuarioAreasService {

	UsuarioAreas save(UsuarioAreas param);
	
	UsuarioAreas update(UsuarioAreas param);
	
	List<UsuarioAreas> getAllRows();
	
	Optional<UsuarioAreas> getRow(Long param);
	
	void deleteRow(Long param);

}
