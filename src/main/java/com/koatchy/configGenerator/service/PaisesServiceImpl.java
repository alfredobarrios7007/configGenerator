package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.dao.*;
import com.koatchy.configGenerator.entity.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaisesServiceImpl implements PaisesService {

	@Autowired(required = true)
	private PaisesDao objectDao;	
	
	@Override
	public Paises save(Paises param) {
		return objectDao.save(param);
	}

	@Override
	public Paises update(Paises param) {
		return objectDao.saveAndFlush(param);
	}

	@Override
	public List<Paises> getAllRows() {
		return objectDao.findAll();
	}

	@Override
	public Optional<Paises> getRow(Long param) {
		return objectDao.findById(param);
	}

	@Override
	public void deleteRow(Long param) {
		objectDao.deleteById(param);
	}

}
