/**
 * 
 */
package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.entity.Project;
import java.util.List;
import java.util.Optional;


/**
 * @author alfredo.barrios
 *
 */
public interface ProjectsService {

	Project save(Project param);
	
	Project update(Project param);
	
	List<Project> getAllRows();
	
	Optional<Project> getRow(Long param);
	
	void deleteRow(Long param);	
	
}
