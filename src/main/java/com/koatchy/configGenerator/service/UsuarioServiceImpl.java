package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.dao.*;
import com.koatchy.configGenerator.entity.*;
import com.koatchy.configGenerator.model.Login;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired(required = true)
	private UsuarioDao objectDao;	
	
	@Override
	public Usuario save(Usuario param) {
		return objectDao.save(param);
	}

	@Override
	public Usuario update(Usuario param) {
		return objectDao.saveAndFlush(param);
	}

	@Override
	public List<Usuario> getAllRows() {
		return objectDao.findAll();
	}

	@Override
	public Optional<Usuario> getRow(Long param) {
		return objectDao.findById(param);
	}
	
	@Override
	public Optional<Usuario> getRowByUsernameAndPassword(Login param){
		return objectDao.findUserByNameAndPassword(param.getUsername(), param.getPassword());		
	}
	
	@Override
	public void deleteRow(Long param) {
		objectDao.deleteById(param);
	}

}
