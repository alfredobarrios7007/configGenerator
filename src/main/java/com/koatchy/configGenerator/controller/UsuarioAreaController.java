/**
 * 
 */
package com.koatchy.configGenerator.controller;

/**
 * @author alfredo.barrios
 *
 */
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
import com.koatchy.configGenerator.entity.UsuarioArea;
import com.koatchy.configGenerator.service.UsuarioAreaService;

@RequestMapping("UsuarioArea")
@RestController
public class UsuarioAreaController implements ServiceController {
	
	@Autowired
	private UsuarioAreaService usuarioAreaServ;
	
	@PostMapping("save")
	public UsuarioArea save(@RequestBody UsuarioArea usuarioArea) {
		System.out.println("save");
		return usuarioAreaServ.saveUsuarioArea(usuarioArea);
	}
	
	@PutMapping("/update")
	public UsuarioArea update(@RequestBody UsuarioArea usuarioArea) {
		System.out.println("update");
		return usuarioAreaServ.updateUsuarioArea(usuarioArea);
	}
	
	@GetMapping("/all")
	public GeneralResponse getAllUsuarioAreas(){
		System.out.println("all");
		return new GeneralResponse(200, "Success", usuarioAreaServ.getAllUsuarioAreas());
	}
	
	@GetMapping("/by/{IdUsuarioArea}")
	public GeneralResponse getUsuarioArea(@PathVariable(name = "IdUsuarioArea") Long Id) {
		System.out.println("by");
		return new GeneralResponse(200, "Success", usuarioAreaServ.getUsuarioArea(Id));
	}

	@GetMapping("/delete/{IdUsuarioArea}")
	public GeneralResponse deleteUsuarioArea(@PathVariable(name = "IdUsuarioArea") Long Id) {
		System.out.println("delete");
		usuarioAreaServ.deleteUsuarioArea(Id);
		return new GeneralResponse(200, "Success");		
	}
	
	@Override
	@ExceptionHandler
	public GeneralResponse handlerException(Exception e) {
		System.out.println(e.toString());
		return new GeneralResponse(-200, "Error: " + e.toString());
	}

}
