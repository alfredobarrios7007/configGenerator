package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.dao.*;
import com.koatchy.configGenerator.entity.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PerfilesServiceImpl implements PerfilesService {

	@Autowired(required = true)
	private PerfilesDao objectDao;	
	
	@Override
	public Perfiles save(Perfiles param) {
		return objectDao.save(param);
	}

	@Override
	public Perfiles update(Perfiles param) {
		return objectDao.saveAndFlush(param);
	}

	@Override
	public List<Perfiles> getAllRows() {
		return objectDao.findAll();
	}

	@Override
	public Optional<Perfiles> getRow(Long param) {
		return objectDao.findById(param);
	}

	@Override
	public void deleteRow(Long param) {
		objectDao.deleteById(param);
	}

}
