/**
 * 
 */
package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.model.GetInitialDataRequest;

/**
 * @author alfredo.barrios
 *
 */
public interface InitialIDDataService {

	String GetMsisdnEncrypted(GetInitialDataRequest data, String Msisdn);
	
}
