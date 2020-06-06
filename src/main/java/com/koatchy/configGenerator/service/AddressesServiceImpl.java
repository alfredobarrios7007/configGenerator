/**
 * 
 */
package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.dao.*;
import com.koatchy.configGenerator.entity.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author alfredo.barrios
 *
 */
@Service
public class AddressesServiceImpl implements AddressesService {

	@Autowired(required = true)
	private AddressesDao objectDao;	
	
	@Override
	public Address save(Address param) {
		return objectDao.save(param);
	}

	@Override
	public Address update(Address param) {
		return objectDao.saveAndFlush(param);
	}

	@Override
	public List<Address> getAllRows() {
		return objectDao.findAll();
	}

	@Override
	public Optional<Address> getRow(Long param) {
		return objectDao.findById(param);
	}

	@Override
	public void deleteRow(Long param) {
		objectDao.deleteById(param);
	}

}
