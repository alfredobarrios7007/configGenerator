package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.dao.*;
import com.koatchy.configGenerator.entity.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CambiosServiceImpl implements CambiosService {

	@Autowired(required = true)
	private CambiosDao objectDao;	
	
	@Override
	public Cambios save(Cambios param) {
		return objectDao.save(param);
	}

	@Override
	public Cambios update(Cambios param) {
		return objectDao.saveAndFlush(param);
	}

	@Override
	public List<Cambios> getAllRows() {
		return objectDao.findAll();
	}

	@Override
	public Optional<Cambios> getRow(Long param) {
		return objectDao.findById(param);
	}

	@Override
	public void deleteRow(Long param) {
		objectDao.deleteById(param);
	}

}
