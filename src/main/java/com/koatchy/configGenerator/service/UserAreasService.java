/**
 * 
 */
package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.entity.UserArea;
import java.util.List;
import java.util.Optional;


/**
 * @author alfredo.barrios
 *
 */
public interface UserAreasService {

	UserArea save(UserArea param);
	
	UserArea update(UserArea param);
	
	List<UserArea> getAllRows();
	
	Optional<UserArea> getRow(Long param);
	
	void deleteRow(Long param);	
	
}
