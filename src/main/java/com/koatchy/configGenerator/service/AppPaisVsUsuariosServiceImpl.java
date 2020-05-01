package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.dao.*;
import com.koatchy.configGenerator.entity.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppPaisVsUsuariosServiceImpl implements AppPaisVsUsuariosService {

	@Autowired(required = true)
	private AppPaisVsUsuariosDao objectDao;	
	
	@Override
	public AppPaisVsUsuarios save(AppPaisVsUsuarios param) {
		return objectDao.save(param);
	}

	@Override
	public AppPaisVsUsuarios update(AppPaisVsUsuarios param) {
		return objectDao.saveAndFlush(param);
	}

	@Override
	public List<AppPaisVsUsuarios> getAllRows() {
		return objectDao.findAll();
	}

	@Override
	public Optional<AppPaisVsUsuarios> getRow(Long param) {
		return objectDao.findById(param);
	}

	@Override
	public void deleteRow(Long param) {
		objectDao.deleteById(param);
	}

}
