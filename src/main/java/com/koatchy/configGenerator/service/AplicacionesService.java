package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.entity.*;
import java.util.List;
import java.util.Optional;


/**
 * @author alfredo.barrios
 *
 */
public interface AplicacionesService {

	Aplicaciones save(Aplicaciones param);
	
	Aplicaciones update(Aplicaciones param);
	
	List<Aplicaciones> getAllRows();
	
	Optional<Aplicaciones> getRow(Long param);
	
	void deleteRow(Long param);
	
}
