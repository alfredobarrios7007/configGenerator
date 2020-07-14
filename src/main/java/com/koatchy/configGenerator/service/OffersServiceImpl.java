/**
 * 
 */
package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.dao.OffersDao;
import com.koatchy.configGenerator.dao.SubscriptionsDao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koatchy.configGenerator.entity.Offer;

/**
 * @author alfredo.barrios
 *
 */
@Service
public class OffersServiceImpl implements OffersService {


	@Autowired(required = true)
	private OffersDao objectDao;	
	
	@Override
	public Offer save(Offer param) {
		return objectDao.save(param);
	}

	@Override
	public Offer update(Offer param) {
		return objectDao.saveAndFlush(param);
	}

	@Override
	public List<Offer> getAllRows() {
		return objectDao.findAll();
	}

	@Override
	public Optional<Offer> getRow(Long param) {
		return objectDao.findById(param);
	}

	@Override
	public void deleteRow(Long param) {
		objectDao.deleteById(param);
	}

}
