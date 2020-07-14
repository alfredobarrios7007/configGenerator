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
public class ProjectsServiceImpl implements ProjectsService {

	@Autowired(required = true)
	private ProjectsDao objectDao;	
	
	@Override
	public Project save(Project param) {
		return objectDao.save(param);
	}

	@Override
	public Project update(Project param) {
		return objectDao.saveAndFlush(param);
	}

	@Override
	public List<Project> getAllRows() {
		return objectDao.findAll();
	}

	@Override
	public Optional<Project> getRow(Long param) {
		return objectDao.findById(param);
	}

	@Override
	public void deleteRow(Long param) {
		objectDao.deleteById(param);
	}

	
	@Override
	public Optional<Project> findProjectsByUser(Long id){
		return objectDao.findProjectsByUser(id);
	}
	
	@Override
	public Optional<Project> findProjectsByOrganization(Long id){
		return objectDao.findProjectsByOrganization(id);
	}
	
	
}
