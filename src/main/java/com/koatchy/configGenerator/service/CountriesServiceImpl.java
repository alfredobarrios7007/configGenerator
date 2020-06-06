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
public class CountriesServiceImpl implements CountriesService {

	@Autowired(required = true)
	private CountriesDao objectDao;	
	
	@Override
	public Country save(Country param) {
		return objectDao.save(param);
	}

	@Override
	public Country update(Country param) {
		return objectDao.saveAndFlush(param);
	}

	@Override
	public List<Country> getAllRows() {
		return objectDao.findAll();
	}

	@Override
	public Optional<Country> getRow(Long param) {
		return objectDao.findById(param);
	}

	@Override
	public void deleteRow(Long param) {
		objectDao.deleteById(param);
	}

}
