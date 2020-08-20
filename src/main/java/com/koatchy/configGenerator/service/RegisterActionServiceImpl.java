/**
 * 
 */
package com.koatchy.configGenerator.service;

import org.springframework.stereotype.Service;

import com.koatchy.configGenerator.model.ActionRegistered;

/**
 * @author alfredo.barrios
 *
 */
@Service
public class RegisterActionServiceImpl implements RegisterActionService {
	public Boolean register(ActionRegistered param) {
		return true;
	}
}
