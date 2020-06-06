/**
 * 
 */
package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.entity.Address;
import java.util.List;
import java.util.Optional;


/**
 * @author alfredo.barrios
 *
 */
public interface AddressesService {

	Address save(Address param);
	
	Address update(Address param);
	
	List<Address> getAllRows();
	
	Optional<Address> getRow(Long param);
	
	void deleteRow(Long param);	
	
}
