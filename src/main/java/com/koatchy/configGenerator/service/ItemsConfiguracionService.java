package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.entity.*;
import java.util.List;
import java.util.Optional;


/**
 * @author alfredo.barrios
 *
 */
public interface ItemsConfiguracionService {

	ItemsConfiguracion save(ItemsConfiguracion param);
	
	ItemsConfiguracion update(ItemsConfiguracion param);
	
	List<ItemsConfiguracion> getAllRows();
	
	Optional<ItemsConfiguracion> getRow(Long param);
	
	void deleteRow(Long param);
	
}
