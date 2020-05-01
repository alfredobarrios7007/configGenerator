package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.entity.*;
import java.util.List;
import java.util.Optional;


/**
 * @author alfredo.barrios
 *
 */
public interface CambiosService {

	Cambios save(Cambios param);
	
	Cambios update(Cambios param);
	
	List<Cambios> getAllRows();
	
	Optional<Cambios> getRow(Long param);
	
	void deleteRow(Long param);
	
}
