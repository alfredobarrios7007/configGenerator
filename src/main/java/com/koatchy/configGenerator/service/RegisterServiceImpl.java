/**
 * 
 */
package com.koatchy.configGenerator.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.koatchy.configGenerator.exception.RegisterException;
import com.koatchy.configGenerator.model.Register;

/**
 * @author alfredo.barrios
 *
 */
@Service
public class RegisterServiceImpl implements RegisterService {

	@Override
	public Register add(Register user) throws RegisterException {
		// TODO Auto-generated method stub
		System.out.print(user.toString());
		return user;
	}

	@Override
	public Register modify(Register user) throws RegisterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Long idUser) throws RegisterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Register> getRows() throws RegisterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Register> getRowsByCompany(Long idCompany) throws RegisterException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
