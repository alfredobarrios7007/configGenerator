package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.entity.*;
import java.util.List;
import java.util.Optional;


/**
 * @author alfredo.barrios
 *
 */
public interface AplicacionVersionPaisService {

	AplicacionVersionPais save(AplicacionVersionPais param);
	
	AplicacionVersionPais update(AplicacionVersionPais param);
	
	List<AplicacionVersionPais> getAllRows();
	
	Optional<AplicacionVersionPais> getRow(Long param);
	
	void deleteRow(Long param);
	
}
