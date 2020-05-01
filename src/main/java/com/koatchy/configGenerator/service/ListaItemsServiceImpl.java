package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.dao.*;
import com.koatchy.configGenerator.entity.*;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ListaItemsServiceImpl implements ListaItemsService {

	@Autowired(required = true)
	private ListaItemsDao objectDao;	
	
	@Override
	public ListaItems save(ListaItems param) {
		return objectDao.save(param);
	}

	@Override
	public ListaItems update(ListaItems param) {
		return objectDao.saveAndFlush(param);
	}

	@Override
	public List<ListaItems> getAllRows() {
		return objectDao.findAll();
	}

	@Override
	public Optional<ListaItems> getRow(Long param) {
		return objectDao.findById(param);
	}

	@Override
	public void deleteRow(Long param) {
		objectDao.deleteById(param);
	}

}
