package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.entity.*;
import java.util.List;
import java.util.Optional;


/**
 * @author alfredo.barrios
 *
 */
public interface ConfiguracionesService {

	Configuraciones save(Configuraciones param);
	
	Configuraciones update(Configuraciones param);
	
	List<Configuraciones> getAllRows();
	
	Optional<Configuraciones> getRow(Long param);
	
	void deleteRow(Long param);
	
}
