/**
 * 
 */
package com.koatchy.configGenerator.service;

import java.util.List;
import java.util.Optional;

import com.koatchy.configGenerator.entity.Subscription;

/**
 * @author alfredo.barrios
 *
 */
public interface SubscriptionsService {

	Subscription save(Subscription param);
	
	Subscription update(Subscription param);
	
	List<Subscription> getAllRows();
	
	Optional<Subscription> getRow(Long param);
	
	void deleteRow(Long param);	
	
	Optional<Subscription> findProjectsByUser(Long id);
	
	Optional<Subscription> findProjectsByOrganization(Long id);

}
