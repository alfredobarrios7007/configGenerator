package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.entity.*;
import java.util.List;
import java.util.Optional;


/**
 * @author alfredo.barrios
 *
 */
public interface VersionesService {

	Versiones save(Versiones param);
	
	Versiones update(Versiones param);
	
	List<Versiones> getAllRows();
	
	Optional<Versiones> getRow(Long param);
	
	void deleteRow(Long param);
	
}
