/**
 * 
 */
package com.koatchy.configGenerator.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koatchy.configGenerator.dao.SubscriptionsDao;
import com.koatchy.configGenerator.entity.Subscription;


/**
 * @author alfredo.barrios
 *
 */
@Service
public class SubscriptionsServiceImpl implements SubscriptionsService {


	@Autowired(required = true)
	private SubscriptionsDao objectDao;	
	
	@Override
	public Subscription save(Subscription param) {
		return objectDao.save(param);
	}

	@Override
	public Subscription update(Subscription param) {
		return objectDao.saveAndFlush(param);
	}

	@Override
	public List<Subscription> getAllRows() {
		return objectDao.findAll();
	}

	@Override
	public Optional<Subscription> getRow(Long param) {
		return objectDao.findById(param);
	}

	@Override
	public void deleteRow(Long param) {
		objectDao.deleteById(param);
	}

	@Override
	public Optional<Subscription> findProjectsByUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Subscription> findProjectsByOrganization(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
