package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.entity.*;
import java.util.List;
import java.util.Optional;


/**
 * @author alfredo.barrios
 *
 */
public interface PerfilesService {

	Perfiles save(Perfiles param);
	
	Perfiles update(Perfiles param);
	
	List<Perfiles> getAllRows();
	
	Optional<Perfiles> getRow(Long param);
	
	void deleteRow(Long param);
	
}
