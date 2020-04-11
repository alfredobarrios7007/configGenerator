package com.koatchy.configGenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koatchy.configGenerator.model.GeneralResponse;
import com.koatchy.configGenerator.entity.Usuario;
import com.koatchy.configGenerator.service.UsuarioService;
import com.koatchy.configGenerator.service.UsuarioServiceImpl;

@RequestMapping("Usuario")
@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioServ;
	
	@PostMapping("save")
	public Usuario save(@RequestBody Usuario usuario) {
		System.out.println("save: " + usuario.toString());
		return usuarioServ.saveUsuario(usuario);
	}
	
	@PutMapping("/update")
	public Usuario update(@RequestBody Usuario usuario) {
		System.out.println("update");
		return usuarioServ.updateUsuario(usuario);
	}
	
	@GetMapping("/all")
	public GeneralResponse getAllUsuarios(){
		System.out.println("all");
		return new GeneralResponse(200, "Success", usuarioServ.getAllUsuarios());
	}
	
	@GetMapping("/by/{IdUsuario}")
	public GeneralResponse getUsuario(@PathVariable(name = "IdUsuario") Long Id) {
		System.out.println("by");
		return new GeneralResponse(200, "Success", usuarioServ.getUsuario(Id));
	}

	@GetMapping("/delete/{IdUsuario}")
	public GeneralResponse deleteUsuario(@PathVariable(name = "IdUsuario") Long Id) {
		System.out.println("delete");
		usuarioServ.deleteUsuario(Id);
		return new GeneralResponse(200, "Success");		
	}
	
	@ExceptionHandler
	public GeneralResponse handlerException(Exception e) {
		System.out.println(e.toString());
		return new GeneralResponse(-200, "Error: " + e.toString());
	}

}
