/**
 * 
 */
package com.koatchy.configGenerator.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.koatchy.configGenerator.exception.*;
import com.koatchy.configGenerator.exception.SecurityException;
import com.koatchy.configGenerator.model.*;
import com.koatchy.configGenerator.tools.*;
import com.koatchy.configGenerator.dao.*;
import com.koatchy.configGenerator.entity.*;

/**
 * @author alfredo.barrios
 * It class register user and modify user data
 */
@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired(required = true)
	RegisterStoredProcDao registerDao;
	
	@Autowired(required = true)
	ConfigurationsService configSrv;
	
	@Autowired(required = true)
	private UsersDao objectDao;	
		
	private EmailTemplate fillRegistryEmailTemplate() {
		String host = "";
		Integer port = 0;
		String from = "";
		String subject = "";
		String message = "";
		System.out.print("fillEmailTemplate 1\n");
		Optional<Configuration> rowCnf1 = configSrv.findByDescription("emailHost");
		System.out.print("fillEmailTemplate 2\n");
		Optional<Configuration> rowCnf2 = configSrv.findByDescription("emailPort");
		System.out.print("fillEmailTemplate 3\n");
		Optional<Configuration> rowCnf3 = configSrv.findByDescription("RegisterConfirmFrom");
		System.out.print("fillEmailTemplate 4\n");
		Optional<Configuration> rowCnf4 = configSrv.findByDescription("RegisterConfirmSubject");
		System.out.print("fillEmailTemplate 5\n");
		Optional<Configuration> rowCnf5 = configSrv.findByDescription("RegisterConfirmMessage");
		if(rowCnf1.isPresent()) {
			host = rowCnf1.get().getValueOf();
		}
		if(rowCnf2.isPresent()) {
			port = Integer.parseInt(rowCnf2.get().getValueOf());
		}
		if(rowCnf3.isPresent()) {
			from = rowCnf3.get().getValueOf();
		}
		if(rowCnf4.isPresent()) {
			subject = rowCnf4.get().getValueOf();
		}
		if(rowCnf5.isPresent()) {
			message = rowCnf5.get().getValueOf();
		}
		return new EmailTemplate(host,port,from,"",subject,message);
	}

	@Override
	public RegisterRequest add(RegisterRequest user) throws RegisterException {
		System.out.print("RegisterServiceImpl add 0\n");
		try {
			String ePwd = EncryptUtil.encode("~KöAtcHy¬" + user.getEmail(), user.getPassword());
			System.out.print("RegisterServiceImpl add 1: " + user.getPassword() + " | " + ePwd + " \n");
			System.out.print("RegisterServiceImpl add 2: " + user.toString() + " \n");
			registerDao.register(user.getPlatform(), user.getName(), user.getLastname(), user.getOrganization(), user.getArea(), user.getEmail(), ePwd,"");
			
			System.out.print("RegisterServiceImpl add 3: " + user.getEmail() + " \n");
			Optional<User> usr = objectDao.findUserByEmail(user.getEmail());
			System.out.print("RegisterServiceImpl add 4: " + usr.isPresent() + "\n");
			if (!usr.isPresent()) 
				throw new Exception("DB_ERROR");

			System.out.print("RegisterServiceImpl add 5: " + usr.get().getId() + "\n");
			user.setId(usr.get().getId());
			objectDao.updatePhoto(usr.get().getId(), saveUserPhoto(user.getPhoto(), usr.get().getId()));
			
			System.out.print("RegisterServiceImpl add 6: " + user.toString() + "\n");
			user.setPhoto(null);
			//Send e-mail to confirm the registry
			System.out.print("RegisterServiceImpl add 7\n");
			EmailTemplate emailTemp = fillRegistryEmailTemplate();
			System.out.print("RegisterServiceImpl add 8\n");
			emailTemp.setTo(user.getEmail());
			String msg = emailTemp.getMessage();
			Token tokn = new Token("~KöAtcHy¬");
			msg += tokn.getConfirmRegisterToken(user.getEmail());
			emailTemp.setMessage(msg);
			System.out.print("RegisterServiceImpl add 9 " + msg + "\n");
			/* NEED UNCOMMENT THE FOLLOW LINES */
			//EmailHelper emailH = new EmailHelper();
			//emailH.sendmail(emailTemp);
			
		} catch (Exception e) {
			System.out.print("ERROR RegisterServiceImpl add: " + e.toString() + "\n");
			throw new RegisterException(e.getMessage());
		}
		return user;
	}
	
	@Override
	public RegisterRequest modify(RegisterRequest user) throws RegisterException {
		System.out.print("RegisterServiceImpl modify 0\n");
		try {
			String ePwd = EncryptUtil.encode("~KöAtcHy¬" + user.getEmail(), user.getPassword());
			System.out.print("RegisterServiceImpl modify 1: " + user.getPassword() + " | " + ePwd + " \n");
			System.out.print("RegisterServiceImpl modify 2: " + user.toString() + " \n");
			registerDao.register(user.getPlatform(), user.getName(), user.getLastname(), user.getOrganization(), user.getArea(), user.getEmail(), ePwd,"");
			System.out.print("RegisterServiceImpl modify 3: " + user.getEmail() + " \n");
			Optional<User> usr = objectDao.findUserByEmail(user.getEmail());
			System.out.print("RegisterServXiceImpl modify 4: " + usr.isPresent() + "\n");
			if (usr.isPresent()) {
				System.out.print("RegisterServiceImpl modify 5: " + usr.get().getId() + "\n");
				user.setId(usr.get().getId());
				objectDao.updatePhoto(usr.get().getId(), saveUserPhoto(user.getPhoto(), usr.get().getId()));
			}
			System.out.print("RegisterServiceImpl modify 6: " + user.toString() + "\n");
			user.setPhoto(null);
		} catch (Exception e) {
			System.out.print("ERROR RegisterServiceImpl modify: " + e.toString() + "\n");
			throw new RegisterException(e.getMessage());
		}
		return user;
	}
	
	@Override
	public RegisterRequest get(GetMyProfileRequest user) throws GetMyProfileException {
		return null;
	}
	
	private String saveUserPhoto(MultipartFile photo, Long userId) throws IOException {
		System.out.print("saveUserPhoto 1: " + userId + "\n");
		String result = "";
		String photoBasePath = "";
		Optional<Configuration> rowCnf = configSrv.findByDescription("PhotoDirectory");
		if(rowCnf.isPresent()) {
			photoBasePath = rowCnf.get().getValueOf();
		}

		if (photo.isEmpty()) {
			return result;
		}

		try {
			// read and write the file to the selected location-
			byte[] bytes = photo.getBytes();
			result = photoBasePath + "\\" + userId + ".jpg";// photo.getOriginalFilename();
			System.out.print("saveUserPhoto 2: " + photoBasePath + "\n");
			Path path = Paths.get(result);
			Files.write(path, bytes);

		} catch (IOException e) {
			System.out.print("ERROR RegisterServiceImpl savePhoto: " + e.toString() + "\n");
			throw e;
		}		
		
		
		return result;
	}
		
	@Override
	public RegisterConfirmReponse verifyConfirmCode(VerifyCodeRequest code) throws RegisterConfirmException{
		System.out.print("verifyConfirmCode 1: " + code.toString() + "\n");
		Token token = new Token("configGenerator");
		RegisterConfirmReponse result = new RegisterConfirmReponse();
		try {
			//"RegisterConfirm|" + email + "|" + getCurrentDate()
			String decode = token.verifyConfirmRegisterToken(code);
			//List<String> stringList = Pattern.compile("|").splitAsStream(decode).collect(Collectors.toList());
			String stringList[] = decode.split("\\|");
			String email = stringList[1];
			System.out.print("verifyConfirmCode 2\n");
			Optional<User> user = objectDao.findUserByEmail(email);
			if (!user.isPresent()) {
				throw new Exception("EMAIL_NOT_FOUND");
			}
			System.out.print("verifyConfirmCode 3\n");
			//Update status confirm user
			objectDao.updateConfirm(user.get().getId());
			//Welcome message
			System.out.print("verifyConfirmCode 4\n");
			Optional<Configuration> rowCnf1 = configSrv.findByDescription("RegisterWelcomeMessage");
			result.setUsername(user.get().getName() + " " +  user.get().getLastname());
			result.setWelcomeMessage(rowCnf1.get().getValueOf());			

		} catch (Exception e) {
			System.out.print("Error verifyChangePasswordCode\n");
			throw new RegisterConfirmException(e.getMessage());
		}
		return result;
	}

}
