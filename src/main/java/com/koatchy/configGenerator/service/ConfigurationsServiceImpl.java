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
public class ConfigurationsServiceImpl implements ConfigurationsService {

	@Autowired(required = true)
	private ConfigurationsDao objectDao;	
	
	@Override
	public Configuration save(Configuration param) {
		return objectDao.save(param);
	}

	@Override
	public Configuration update(Configuration param) {
		return objectDao.saveAndFlush(param);
	}

	@Override
	public List<Configuration> getAllRows() {
		return objectDao.findAll();
	}

	@Override
	public Optional<Configuration> getRow(Long param) {
		return objectDao.findById(param);
	}

	@Override
	public void deleteRow(Long param) {
		objectDao.deleteById(param);
	}

}
