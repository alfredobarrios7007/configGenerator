/**
 * 
 */
package com.koatchy.configGenerator.service;

import java.util.List;

import com.koatchy.configGenerator.exception.RegisterException;
import com.koatchy.configGenerator.model.Register;

/**
 * @author alfredo.barrios
 *
 */
public interface RegisterService {
	
	Register add(Register user) throws RegisterException;
	
	Register modify(Register user) throws RegisterException;
	
	Boolean delete(Long idUser) throws RegisterException;
	
	List<Register> getRows() throws RegisterException;
	
	List<Register> getRowsByCompany(Long idCompany) throws RegisterException;
	
}
