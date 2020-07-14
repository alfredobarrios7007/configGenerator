/**
 * 
 */
package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.entity.Project;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;


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
	
	Optional<Project> findProjectsByUser(Long id);
	
	Optional<Project> findProjectsByOrganization(Long id);
	
}
