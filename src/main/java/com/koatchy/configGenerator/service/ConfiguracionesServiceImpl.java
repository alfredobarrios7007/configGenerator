package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.dao.*;
import com.koatchy.configGenerator.entity.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ConfiguracionesServiceImpl implements ConfiguracionesService {

	@Autowired(required = true)
	private ConfiguracionesDao objectDao;	
	
	@Override
	public Configuraciones save(Configuraciones param) {
		return objectDao.save(param);
	}

	@Override
	public Configuraciones update(Configuraciones param) {
		return objectDao.saveAndFlush(param);
	}

	@Override
	public List<Configuraciones> getAllRows() {
		return objectDao.findAll();
	}

	@Override
	public Optional<Configuraciones> getRow(Long param) {
		return objectDao.findById(param);
	}

	@Override
	public void deleteRow(Long param) {
		objectDao.deleteById(param);
	}

}
