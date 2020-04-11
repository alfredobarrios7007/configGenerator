package com.koatchy.configGenerator.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koatchy.configGenerator.dao.UsuarioDao;
import com.koatchy.configGenerator.entity.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired(required = true)
	private UsuarioDao usuarioDao;	
	
	@Override
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioDao.save(usuario);
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		return usuarioDao.saveAndFlush(usuario);
	}

	@Override
	public List<Usuario> getAllUsuarios() {
		return usuarioDao.findAll();
	}

	@Override
	public Optional<Usuario> getUsuario(Long IdUsuario) {
		return usuarioDao.findById(IdUsuario);
	}

	@Override
	public void deleteUsuario(Long IdUsuario) {
		usuarioDao.deleteById(IdUsuario);
	}

}
