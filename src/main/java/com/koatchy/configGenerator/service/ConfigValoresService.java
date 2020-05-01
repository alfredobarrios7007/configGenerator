package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.entity.*;
import java.util.List;
import java.util.Optional;


/**
 * @author alfredo.barrios
 *
 */
public interface ConfigValoresService {

	ConfigValores save(ConfigValores param);
	
	ConfigValores update(ConfigValores param);
	
	List<ConfigValores> getAllRows();
	
	Optional<ConfigValores> getRow(Long param);
	
	void deleteRow(Long param);
	
}
