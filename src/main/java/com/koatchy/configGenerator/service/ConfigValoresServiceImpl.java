package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.dao.*;
import com.koatchy.configGenerator.entity.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ConfigValoresServiceImpl implements ConfigValoresService {

	@Autowired(required = true)
	private ConfigValoresDao objectDao;	
	
	@Override
	public ConfigValores save(ConfigValores param) {
		return objectDao.save(param);
	}

	@Override
	public ConfigValores update(ConfigValores param) {
		return objectDao.saveAndFlush(param);
	}

	@Override
	public List<ConfigValores> getAllRows() {
		return objectDao.findAll();
	}

	@Override
	public Optional<ConfigValores> getRow(Long param) {
		return objectDao.findById(param);
	}

	@Override
	public void deleteRow(Long param) {
		objectDao.deleteById(param);
	}

}
