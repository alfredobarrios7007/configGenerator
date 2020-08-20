/**
 * 
 */
package com.koatchy.configGenerator.service;

import java.util.List;
import java.util.Optional;

import com.koatchy.configGenerator.entity.Offer;

/**
 * @author alfredo.barrios
 *
 */
public interface OffersService {

	Offer save(Offer param);
	
	Offer update(Offer param);
	
	List<Offer> getAllRows();
	
	Optional<Offer> getRow(Long param);
	
	void deleteRow(Long param);	

}
