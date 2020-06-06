/**
 * 
 */
package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.entity.Configuration;
import java.util.List;
import java.util.Optional;


/**
 * @author alfredo.barrios
 *
 */
public interface ConfigurationsService {

	Configuration save(Configuration param);
	
	Configuration update(Configuration param);
	
	List<Configuration> getAllRows();
	
	Optional<Configuration> getRow(Long param);
	
	void deleteRow(Long param);	
	
}
