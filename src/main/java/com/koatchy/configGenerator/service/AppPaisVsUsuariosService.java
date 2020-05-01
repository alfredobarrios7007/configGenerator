package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.entity.*;
import java.util.List;
import java.util.Optional;


/**
 * @author alfredo.barrios
 *
 */
public interface AppPaisVsUsuariosService {

	AppPaisVsUsuarios save(AppPaisVsUsuarios param);
	
	AppPaisVsUsuarios update(AppPaisVsUsuarios param);
	
	List<AppPaisVsUsuarios> getAllRows();
	
	Optional<AppPaisVsUsuarios> getRow(Long param);
	
	void deleteRow(Long param);
	
}
