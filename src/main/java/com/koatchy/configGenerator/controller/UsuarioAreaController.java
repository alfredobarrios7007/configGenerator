/**
 * 
 */
package com.koatchy.configGenerator.controller;

/**
 * @author alfredo.barrios
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
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

@RequestMapping("UsuarioArea")
@RestController
public class UsuarioAreaController extends ApiController {
	
	@Autowired
	private UsuarioAreasService serviceObj;
	
	@PostMapping("save")
	public UsuarioAreas save(@RequestBody UsuarioAreas param) {
		System.out.println("save");
		return serviceObj.save(param);
	}
	
	@PutMapping("/update")
	public UsuarioAreas update(@RequestBody UsuarioAreas param) {
		System.out.println("update");
		return serviceObj.update(param);
	}
	
	@GetMapping("/all")
	public GeneralResponse getAllRows(){
		System.out.println("all");
		return new GeneralResponse(200, "Success", serviceObj.getAllRows());
	}
	
	@GetMapping("/by/{Id}")
	public GeneralResponse getRow(@PathVariable(name = "Id") Long Id) {
		System.out.println("by");
		return new GeneralResponse(200, "Success", serviceObj.getRow(Id));
	}

	@GetMapping("/delete/{Id}")
	public GeneralResponse deleteRow(@PathVariable(name = "Id") Long Id) {
		System.out.println("delete");
		serviceObj.deleteRow(Id);
		return new GeneralResponse(200, "Success");		
	}

}
