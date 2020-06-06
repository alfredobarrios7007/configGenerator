/**
 * 
 */
package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.entity.Country;
import java.util.List;
import java.util.Optional;


/**
 * @author alfredo.barrios
 *
 */
public interface CountriesService {

	Country save(Country param);
	
	Country update(Country param);
	
	List<Country> getAllRows();
	
	Optional<Country> getRow(Long param);
	
	void deleteRow(Long param);	
	
}
