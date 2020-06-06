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
public class OrganizationsServiceImpl implements OrganizationsService {

	@Autowired(required = true)
	private OrganizationsDao objectDao;	
	
	@Override
	public Organization save(Organization param) {
		return objectDao.save(param);
	}

	@Override
	public Organization update(Organization param) {
		return objectDao.saveAndFlush(param);
	}

	@Override
	public List<Organization> getAllRows() {
		return objectDao.findAll();
	}

	@Override
	public Optional<Organization> getRow(Long param) {
		return objectDao.findById(param);
	}

	@Override
	public void deleteRow(Long param) {
		objectDao.deleteById(param);
	}

}
