package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.dao.*;
import com.koatchy.configGenerator.entity.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BitacoraServiceImpl implements BitacoraService {

	@Autowired(required = true)
	private BitacoraDao objectDao;	
	
	@Override
	public Bitacora save(Bitacora param) {
		return objectDao.save(param);
	}

	@Override
	public Bitacora update(Bitacora param) {
		return objectDao.saveAndFlush(param);
	}

	@Override
	public List<Bitacora> getAllRows() {
		return objectDao.findAll();
	}

	@Override
	public Optional<Bitacora> getRow(Long param) {
		return objectDao.findById(param);
	}

	@Override
	public void deleteRow(Long param) {
		objectDao.deleteById(param);
	}

}
