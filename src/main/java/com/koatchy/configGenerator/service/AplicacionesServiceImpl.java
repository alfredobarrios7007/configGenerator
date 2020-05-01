package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.dao.*;
import com.koatchy.configGenerator.entity.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AplicacionesServiceImpl implements AplicacionesService {

	@Autowired(required = true)
	private AplicacionesDao objectDao;	
	
	@Override
	public Aplicaciones save(Aplicaciones param) {
		return objectDao.save(param);
	}

	@Override
	public Aplicaciones update(Aplicaciones param) {
		return objectDao.saveAndFlush(param);
	}

	@Override
	public List<Aplicaciones> getAllRows() {
		return objectDao.findAll();
	}

	@Override
	public Optional<Aplicaciones> getRow(Long param) {
		return objectDao.findById(param);
	}

	@Override
	public void deleteRow(Long param) {
		objectDao.deleteById(param);
	}

}
