package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.entity.*;
import java.util.List;
import java.util.Optional;


/**
 * @author alfredo.barrios
 *
 */
public interface PaisesService {

	Paises save(Paises param);
	
	Paises update(Paises param);
	
	List<Paises> getAllRows();
	
	Optional<Paises> getRow(Long param);
	
	void deleteRow(Long param);
	
}
