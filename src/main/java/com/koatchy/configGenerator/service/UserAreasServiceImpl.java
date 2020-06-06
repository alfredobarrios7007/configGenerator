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
public class UserAreasServiceImpl implements UserAreasService {

	@Autowired(required = true)
	private UserAreasDao objectDao;	
	
	@Override
	public UserArea save(UserArea param) {
		return objectDao.save(param);
	}

	@Override
	public UserArea update(UserArea param) {
		return objectDao.saveAndFlush(param);
	}

	@Override
	public List<UserArea> getAllRows() {
		return objectDao.findAll();
	}

	@Override
	public Optional<UserArea> getRow(Long param) {
		return objectDao.findById(param);
	}

	@Override
	public void deleteRow(Long param) {
		objectDao.deleteById(param);
	}

}
