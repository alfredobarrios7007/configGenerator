/**
 * 
 */
package com.koatchy.configGenerator.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koatchy.configGenerator.dao.UsuarioAreaDao;
import com.koatchy.configGenerator.entity.UsuarioArea;


/**
 * @author alfredo.barrios
 *
 */
@Service
public class UsuarioAreaServiceImpl implements UsuarioAreaService {

	@Autowired(required = true)
	private UsuarioAreaDao usuarioAreaDao;	
	
	@Override
	public UsuarioArea saveUsuarioArea(UsuarioArea usuarioArea) {
		return usuarioAreaDao.save(usuarioArea);
	}

	@Override
	public UsuarioArea updateUsuarioArea(UsuarioArea usuarioArea) {
		return usuarioAreaDao.saveAndFlush(usuarioArea);
	}

	@Override
	public List<UsuarioArea> getAllUsuarioAreas() {
		return usuarioAreaDao.findAll();
	}

	@Override
	public Optional<UsuarioArea> getUsuarioArea(Long IdUsuarioArea) {
		return usuarioAreaDao.findById(IdUsuarioArea);
	}

	@Override
	public void deleteUsuarioArea(Long IdUsuarioArea) {
		usuarioAreaDao.deleteById(IdUsuarioArea);
	}

}
