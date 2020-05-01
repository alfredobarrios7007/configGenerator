package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.dao.*;
import com.koatchy.configGenerator.entity.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemsConfiguracionServiceImpl implements ItemsConfiguracionService {

	@Autowired(required = true)
	private ItemsConfiguracionDao objectDao;	
	
	@Override
	public ItemsConfiguracion save(ItemsConfiguracion param) {
		return objectDao.save(param);
	}

	@Override
	public ItemsConfiguracion update(ItemsConfiguracion param) {
		return objectDao.saveAndFlush(param);
	}

	@Override
	public List<ItemsConfiguracion> getAllRows() {
		return objectDao.findAll();
	}

	@Override
	public Optional<ItemsConfiguracion> getRow(Long param) {
		return objectDao.findById(param);
	}

	@Override
	public void deleteRow(Long param) {
		objectDao.deleteById(param);
	}

}
