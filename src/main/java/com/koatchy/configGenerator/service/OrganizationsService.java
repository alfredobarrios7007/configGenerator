/**
 * 
 */
package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.entity.Organization;
import java.util.List;
import java.util.Optional;


/**
 * @author alfredo.barrios
 *
 */
public interface OrganizationsService {

	Organization save(Organization param);
	
	Organization update(Organization param);
	
	List<Organization> getAllRows();
	
	Optional<Organization> getRow(Long param);
	
	void deleteRow(Long param);	
	
}
