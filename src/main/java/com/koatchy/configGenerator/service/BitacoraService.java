package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.entity.*;
import java.util.List;
import java.util.Optional;


/**
 * @author alfredo.barrios
 *
 */
public interface BitacoraService {

	Bitacora save(Bitacora param);
	
	Bitacora update(Bitacora param);
	
	List<Bitacora> getAllRows();
	
	Optional<Bitacora> getRow(Long param);
	
	void deleteRow(Long param);
	
}
