/**
 * 
 */
package com.koatchy.configGenerator.service;

import com.koatchy.configGenerator.model.GetInitialDataRequest;
import com.koatchy.configGenerator.tools.EncryptUtil;

/**
 * @author alfredo.barrios
 *
 */
public class InitialIDDataServiceImpl implements InitialIDDataService {

	@Override
	public String GetMsisdnEncrypted(GetInitialDataRequest data, String Msisdn) {
		String result = "";
		result = EncryptUtil.encode(data.getDateTime(), Msisdn);
		return result;
	}	
	
}
