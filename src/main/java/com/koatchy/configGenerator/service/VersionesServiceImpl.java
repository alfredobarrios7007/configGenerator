package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.dao.*;
import com.koatchy.configGenerator.entity.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VersionesServiceImpl implements VersionesService {

	@Autowired(required = true)
	private VersionesDao objectDao;	
	
	@Override
	public Versiones save(Versiones param) {
		return objectDao.save(param);
	}

	@Override
	public Versiones update(Versiones param) {
		return objectDao.saveAndFlush(param);
	}

	@Override
	public List<Versiones> getAllRows() {
		return objectDao.findAll();
	}

	@Override
	public Optional<Versiones> getRow(Long param) {
		return objectDao.findById(param);
	}

	@Override
	public void deleteRow(Long param) {
		objectDao.deleteById(param);
	}

}
