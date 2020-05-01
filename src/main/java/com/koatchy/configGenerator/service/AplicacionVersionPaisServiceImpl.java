package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.dao.*;
import com.koatchy.configGenerator.entity.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AplicacionVersionPaisServiceImpl implements AplicacionVersionPaisService {

	@Autowired(required = true)
	private AplicacionVersionPaisDao objectDao;	
	
	@Override
	public AplicacionVersionPais save(AplicacionVersionPais param) {
		return objectDao.save(param);
	}

	@Override
	public AplicacionVersionPais update(AplicacionVersionPais param) {
		return objectDao.saveAndFlush(param);
	}

	@Override
	public List<AplicacionVersionPais> getAllRows() {
		return objectDao.findAll();
	}

	@Override
	public Optional<AplicacionVersionPais> getRow(Long param) {
		return objectDao.findById(param);
	}

	@Override
	public void deleteRow(Long param) {
		objectDao.deleteById(param);
	}

}
