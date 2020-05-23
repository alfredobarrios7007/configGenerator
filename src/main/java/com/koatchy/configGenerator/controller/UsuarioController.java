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
import com.koatchy.configGenerator.entity.*;
import com.koatchy.configGenerator.service.*;

@RequestMapping("Usuario")
@RestController
public class UsuarioController implements ServiceController {
	
	@Autowired
	private UsuarioService serviceObj;
	
	@PostMapping("save")
	public Usuario save(@RequestBody Usuario param) {
		System.out.println("save: " + param.toString());
		return serviceObj.save(param);
	}
	
	@PutMapping("/update")
	public Usuario update(@RequestBody Usuario param) {
		System.out.println("update");
		return serviceObj.update(param);
	}
	
	@GetMapping("/all")
	public GeneralResponse getAllUsuarios(){
		System.out.println("all");
		return new GeneralResponse(200, "Success", serviceObj.getAllRows());
	}
	
	@GetMapping("/by/{IdU}")
	public GeneralResponse getUsuario(@PathVariable(name = "Id") Long Id) {
		System.out.println("by");
		return new GeneralResponse(200, "Success", serviceObj.getRow(Id));
	}

	@GetMapping("/delete/{Id}")
	public GeneralResponse deleteUsuario(@PathVariable(name = "Id") Long Id) {
		System.out.println("delete");
		serviceObj.deleteRow(Id);
		return new GeneralResponse(200, "Success");		
	}

	
	@Override
	public void validateAuthorization(String authentication) throws Exception  {
		if(!authentication.equals("wDo3rXrE/")) 
			throw new Exception("No está autorizado a usar este servicio");
	}
	
	@Override
	@ExceptionHandler
	public GeneralResponse handlerException(Exception e) {
		System.out.println(e.toString());
		return new GeneralResponse(-200, "Error: " + e.toString());
	}

}
