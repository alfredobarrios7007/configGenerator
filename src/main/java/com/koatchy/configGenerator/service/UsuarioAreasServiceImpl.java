/**
 * 
 */
package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.dao.UsuarioAreasDao;
import com.koatchy.configGenerator.entity.UsuarioAreas;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @author alfredo.barrios
 *
 */
@Service
public class UsuarioAreasServiceImpl implements UsuarioAreasService {

	@Autowired(required = true)
	private UsuarioAreasDao objectDao;	
	
	@Override
	public UsuarioAreas save(UsuarioAreas param) {
		return objectDao.save(param);
	}

	@Override
	public UsuarioAreas update(UsuarioAreas param) {
		return objectDao.saveAndFlush(param);
	}

	@Override
	public List<UsuarioAreas> getAllRows() {
		return objectDao.findAll();
	}

	@Override
	public Optional<UsuarioAreas> getRow(Long param) {
		return objectDao.findById(param);
	}

	@Override
	public void deleteRow(Long param) {
		objectDao.deleteById(param);
	}

}
